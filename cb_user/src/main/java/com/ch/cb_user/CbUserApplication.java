package com.ch.cb_user;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = {"com.ch.cb_user","com.ch.cb_common"})
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
