package com.wooricard.wooricard_eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer // 유레카 서버 역할 활성화
public class WooricardEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(WooricardEurekaApplication.class, args);
	}

}
