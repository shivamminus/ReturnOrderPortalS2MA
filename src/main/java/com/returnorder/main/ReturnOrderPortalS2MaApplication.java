package com.returnorder.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ReturnOrderPortalS2MaApplication {

	public static void main(String[] args) {

        System.setProperty("server.connection-timeout","60000");
		SpringApplication.run(ReturnOrderPortalS2MaApplication.class, args);
	}

}
