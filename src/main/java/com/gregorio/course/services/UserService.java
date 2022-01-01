package com.gregorio.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gregorio.course.entities.User;
import com.gregorio.course.repositories.UserRepository;

@Service
public class UserService {

	@Autowired // INJEÇÃO DE DEPENDÊNCIA
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	// RECUPERAR USUÁRIO POR ID
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}

}
