package com.cjc.Main.AjaxSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com")
public class AjaxSpringBootApplication 
{

	public static void main(String[] args) 
	{
		System.out.println("Project started!!");
		
		SpringApplication.run(AjaxSpringBootApplication.class, args);
	}
 }
   