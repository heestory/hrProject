package com.hr.register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = "classpath:conf.properties")
public class HrHireRegisterApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(HrHireRegisterApplication.class, args);
	}
}
