package com.university.university;

import com.university.university.entities.User;
import com.university.university.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class UniversityApplication {

	public static void main(String[] args) {

		SpringApplication.run(UniversityApplication.class, args);

	}


}

