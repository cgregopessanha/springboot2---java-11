package com.gregorio.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gregorio.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
