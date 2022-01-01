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
		User u3 = new User(null, "Aaron Rodgers", "aarongreenbay@packers.com", "5519876543", "admin3");
		User u4 = new User(null, "Tom Brady", "tom@tampa.com", "123456789", "admin4");
		User u5 = new User(null, "Russel Wilson", "wilson@seahawlcks", "5466356356", "admin4");
		User u6 = new User(null, "Patrick Mahomes", "mahomespatrick@chiefs.com", "098949323004", "adim5");
		User u7 = new User(null, "Josh Allen", "josh@gmail.com", "3425436346352", "admin6");

		// SALVAR NO BANCO DE DADOS
		userRepository.saveAll(Arrays.asList(u1, u2, u3, u4, u5, u6, u7));
	}

}

//DATABASE SEEDING (POPULAR BANCO DE DADOS)