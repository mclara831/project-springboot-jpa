package com.mariaclara.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mariaclara.webservice.entities.OrderItem;
import com.mariaclara.webservice.entities.pk.OrderItemPk;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPk> {
}
