package com.practice.blogmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableReactiveMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@EnableReactiveMongoRepositories
@EnableReactiveMongoAuditing
@SpringBootApplication
public class BlogManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogManagementApplication.class, args);
	}

}
