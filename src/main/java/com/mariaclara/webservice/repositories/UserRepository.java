package com.mariaclara.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mariaclara.webservice.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
