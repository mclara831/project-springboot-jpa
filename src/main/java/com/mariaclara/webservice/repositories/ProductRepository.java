package com.mariaclara.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mariaclara.webservice.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
