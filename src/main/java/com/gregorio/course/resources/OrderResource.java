package com.gregorio.course.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gregorio.course.entities.Order;
import com.gregorio.course.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

	@Autowired
	private OrderService service;

	// OBTENDO UMA LISTA DE USUÁRIOS
	@GetMapping
	public ResponseEntity<List<Order>> findAll() {

		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	// OBTENDO UM USUÁRIO PELO ID
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
