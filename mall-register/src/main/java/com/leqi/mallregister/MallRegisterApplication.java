package com.leqi.mallregister;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MallRegisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(MallRegisterApplication.class, args);
	}

}
