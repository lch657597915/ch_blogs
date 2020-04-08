package com.ch.cb_user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;


/**
 *
 * @author lch
 * @date 2020/3/26
 */
@SpringBootApplication
@EnableEurekaClient
@Slf4j
public class CbUserApplication {

	public static void main(String[] args) {
		Class[] obj = { CbUserApplication.class };
		SpringApplication app = new SpringApplication(obj);
		ApplicationContext context = app.run(args);
		String[] activeProfiles = context.getEnvironment().getActiveProfiles();
		for (String activeProfile : activeProfiles) {
			log.info("启动完毕，当前环境为: " + activeProfile);
		}
	}

}
