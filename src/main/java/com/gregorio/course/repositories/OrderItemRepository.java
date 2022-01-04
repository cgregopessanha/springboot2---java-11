package com.gregorio.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gregorio.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
