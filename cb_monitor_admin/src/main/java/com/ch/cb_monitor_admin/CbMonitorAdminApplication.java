package com.ch.cb_monitor_admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author lch
 * @date 2020/3/26
 */
@EnableAdminServer
@EnableEurekaClient
@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class CbMonitorAdminApplication {

	public static void main(String[] args) {
		Class[] obj = { CbMonitorAdminApplication.class };
		SpringApplication app = new SpringApplication(obj);
		ApplicationContext context = app.run(args);
		String[] activeProfiles = context.getEnvironment().getActiveProfiles();
		for (String activeProfile : activeProfiles) {
			log.info("启动完毕，当前环境为: " + activeProfile);
		}
	}

}
