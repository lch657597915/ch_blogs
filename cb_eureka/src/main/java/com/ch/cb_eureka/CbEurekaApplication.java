package com.ch.cb_eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CbEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CbEurekaApplication.class, args);
	}

}
