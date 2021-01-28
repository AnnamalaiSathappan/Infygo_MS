package com.infosys.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class InfyGoBootConfigServer {

	public static void main(String[] args) {
		SpringApplication.run(InfyGoBootConfigServer.class, args);
	}

}
