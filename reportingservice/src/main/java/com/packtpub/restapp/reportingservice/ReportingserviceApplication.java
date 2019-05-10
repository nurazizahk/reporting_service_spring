package com.packtpub.restapp.reportingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.packtpub")
@SpringBootApplication
public class ReportingserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReportingserviceApplication.class, args);
	}

}