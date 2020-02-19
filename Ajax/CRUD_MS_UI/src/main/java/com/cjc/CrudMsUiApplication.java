package com.cjc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CrudMsUiApplication 
{
	public static void main(String[] args) 
	{
		System.out.println("UI server");
		
		SpringApplication.run(CrudMsUiApplication.class, args);
	}

}
