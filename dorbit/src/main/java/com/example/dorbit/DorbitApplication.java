package com.example.dorbit;

import com.mongodb.client.MongoClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class DorbitApplication {

	@Bean
	public MongoTemplate mongoTemplate() {
		return new MongoTemplate(MongoClients.create(), "sample_restaurants");
	}

	public static void main(String[] args) {
		SpringApplication.run(DorbitApplication.class, args);

	}

}
