package com.university.university;

import com.university.university.entities.User;
import com.university.university.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.Optional;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class UniversityApplication {

	public static void main(String[] args) {

		SpringApplication.run(UniversityApplication.class, args);

	}



}

