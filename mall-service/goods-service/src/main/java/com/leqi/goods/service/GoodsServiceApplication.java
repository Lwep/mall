package com.leqi.goods.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.leqi.goods.service.mapper")
public class GoodsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoodsServiceApplication.class, args);
	}

}
