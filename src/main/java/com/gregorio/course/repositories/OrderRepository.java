package com.gregorio.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gregorio.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
