package com.gregorio.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gregorio.course.entities.Order;
import com.gregorio.course.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired // INJEÇÃO DE DEPENDÊNCIA
	private OrderRepository repository;

	public List<Order> findAll() {
		return repository.findAll();
	}

	// RECUPERAR USUÁRIO POR ID
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}

}
