package com.shahbour;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.deployer.resource.docker.DockerResourceLoader;
import org.springframework.cloud.deployer.resource.support.DelegatingResourceLoader;
import org.springframework.cloud.task.launcher.annotation.EnableTaskLauncher;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableTaskLauncher
public class TaskLauncherApplication {

	@Bean
	public DelegatingResourceLoader delegatingResourceLoader() {
		DockerResourceLoader dockerLoader = new DockerResourceLoader();
		Map<String, ResourceLoader> loaders = new HashMap<>();
		loaders.put("docker", dockerLoader);
		return new DelegatingResourceLoader(loaders);
	}

	public static void main(String[] args) {
		SpringApplication.run(TaskLauncherApplication.class, args);
	}
}
