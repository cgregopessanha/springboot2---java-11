package com.gregorio.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.gregorio.course.entities.User;
import com.gregorio.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	// INJEÇÃO DE DEPENDÊNCIA
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Arnold Swhaznegger", "arnoldbomberman@gmail.com", "85998765432", "admin");
		User u2 = new User(null, "Silverster Stalonne", "rambo@gmail.com", "82973265432", "admin2");

		// SALVAR NO BANCO DE DADOS
		userRepository.saveAll(Arrays.asList(u1, u2));
	}

}

//DATABASE SEEDING (POPULAR BANCO DE DADOS)