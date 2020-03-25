package com.ch.cb_eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableEurekaServer

public class CbEurekaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(CbEurekaApplication.class, args);

		String[] activeProfiles = context.getEnvironment().getActiveProfiles();
		for (String activeProfile : activeProfiles) {
//			log.info("gt-base 使用环境为: " + activeProfile);
		}
		SpringApplication.run(CbEurekaApplication.class, args);
	}

}
