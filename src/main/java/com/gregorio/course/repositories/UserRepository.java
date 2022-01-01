package com.gregorio.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gregorio.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
