package com.shahbour.simpletask;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;

@SpringBootApplication
@EnableTask
@Slf4j
public class SimpleTaskApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SimpleTaskApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		log.info("Testing simple task");
	}
}
