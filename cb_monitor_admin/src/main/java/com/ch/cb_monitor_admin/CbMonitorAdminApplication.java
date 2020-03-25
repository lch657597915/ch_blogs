package com.ch.cb_monitor_admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;

@EnableAdminServer
@EnableEurekaClient
@SpringBootApplication
@EnableDiscoveryClient
public class CbMonitorAdminApplication {

	public static void main(String[] args) {

		SpringApplication.run(CbMonitorAdminApplication.class, args);
	}

}
