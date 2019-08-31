package com.leqi.mallconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MallConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(MallConfigApplication.class, args);
	}

}
