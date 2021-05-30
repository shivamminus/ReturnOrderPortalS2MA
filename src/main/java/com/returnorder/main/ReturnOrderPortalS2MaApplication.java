package com.returnorder.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class ReturnOrderPortalS2MaApplication {
	
	private static Logger logger = LoggerFactory.getLogger(ReturnOrderPortalS2MaApplication.class);
	
	
	public static void main(String[] args) {
		
		
		logger.info("Return Order Portal Started");

//        System.setProperty("server.connection-timeout","120000");
		SpringApplication.run(ReturnOrderPortalS2MaApplication.class, args);
	}

}
