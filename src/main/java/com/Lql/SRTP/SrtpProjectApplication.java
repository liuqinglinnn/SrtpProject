package com.Lql.SRTP;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.Lql.SRTP.dao")
@SpringBootApplication
public class SrtpProjectApplication {
	public static void main(String[] args) {
		SpringApplication.run(SrtpProjectApplication.class, args);
	}
}
