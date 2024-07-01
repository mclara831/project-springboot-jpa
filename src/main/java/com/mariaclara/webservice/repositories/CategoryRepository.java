package com.mariaclara.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mariaclara.webservice.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
