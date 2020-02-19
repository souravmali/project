package com.cjc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MsUiApplication 
{
	

	public static void main(String[] args) 
	{
		System.out.println("UI Server");
		SpringApplication.run(MsUiApplication.class, args);
	}

}
