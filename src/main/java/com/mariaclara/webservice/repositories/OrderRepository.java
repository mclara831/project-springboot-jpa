package com.mariaclara.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mariaclara.webservice.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
