package com.connect.Connect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableTransactionManagement
public class ConnectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConnectApplication.class, args);
	}


	@Bean
	public PlatformTransactionManager falana(MongoDatabaseFactory mongoDatabaseFactory){
		return new MongoTransactionManager(mongoDatabaseFactory);
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

}
