package com.hatmani.CQRS;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.hatmani.CQRS.services.AccountService;



//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@SpringBootApplication
public class BankingCqrsQueryApplication {
	@Autowired
	AccountService _accountService;
	public static void main(String[] args) {
		SpringApplication.run(BankingCqrsQueryApplication.class, args);
	}
@Bean
public void intialisation()
{System.out.println("*****************");
	_accountService.FindAllAccount().forEach(ac->System.out.println(" acc "+ac.getId()));
}

	
}
