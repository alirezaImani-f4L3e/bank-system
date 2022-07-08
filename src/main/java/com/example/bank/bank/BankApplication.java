package com.example.bank.bank;

import com.example.bank.bank.Models.User;
import com.example.bank.bank.dataTypes.Gender;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class BankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);

	}

	@Bean
	BCryptPasswordEncoder passwordEncoder (){
		return new BCryptPasswordEncoder();
	}
}
