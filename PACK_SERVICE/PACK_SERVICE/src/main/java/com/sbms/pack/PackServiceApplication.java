package com.sbms.pack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan("com.sbms.pack")
@EnableMongoRepositories
public class PackServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PackServiceApplication.class, args);
	}

}
