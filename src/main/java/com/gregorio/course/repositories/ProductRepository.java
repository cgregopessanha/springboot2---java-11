package com.gregorio.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gregorio.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
