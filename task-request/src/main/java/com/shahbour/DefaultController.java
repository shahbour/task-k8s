package com.shahbour;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.task.launcher.TaskLaunchRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DefaultController {

    @Autowired
    MessageChannel output;

    private static TaskLaunchRequest createAppDeploymentRequest(String app) {
        Map<String, String> properties = new HashMap<>();
        properties.put("spring.main.web-environment", "false");
        String uri = "docker:simple-task:0.0.1";
        TaskLaunchRequest taskLaunchRequest = new TaskLaunchRequest(uri,null,properties,null,app);
        return taskLaunchRequest;
    }

    @GetMapping("/{count}")
    public ResponseEntity<Void> runTask(@PathVariable("count") int count) {
        for (int i = 0; i < count; i++) {
            String applicationName = "app" + i;
            TaskLaunchRequest request = createAppDeploymentRequest(applicationName);
            output.send(new GenericMessage<Object>(request));
        }
        return ResponseEntity.ok().build();
    }
}
