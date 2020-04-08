package com.ch.cb_common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@s
public class CbCommonApplication {

	public static void main(String[] args) {
		Class[] obj = { CbCommonApplication.class };
		SpringApplication app = new SpringApplication(obj);
		ApplicationContext context = app.run(args);
		String[] activeProfiles = context.getEnvironment().getActiveProfiles();
		for (String activeProfile : activeProfiles) {
			log.info("启动完毕，当前环境为: " + activeProfile);
		}
	}

}
