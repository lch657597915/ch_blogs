package com.ch.cb_eureka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author lch
 * @date 2020/3/26
 */
@SpringBootApplication
@EnableEurekaServer
@Slf4j
public class CbEurekaApplication {

	public static void main(String[] args) {
		Class[] obj = { CbEurekaApplication.class };
		SpringApplication app = new SpringApplication(obj);
		ApplicationContext context = app.run(args);
		String[] activeProfiles = context.getEnvironment().getActiveProfiles();
		for (String activeProfile : activeProfiles) {
			log.info("启动完毕，当前环境为: " + activeProfile);
		}
	}

}
