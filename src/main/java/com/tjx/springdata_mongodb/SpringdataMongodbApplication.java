package com.tjx.springdata_mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class SpringdataMongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringdataMongodbApplication.class, args);
	}

}
