package com.mariaclara.webservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mariaclara.webservice.entities.Order;
import com.mariaclara.webservice.repositories.OrderRepository;

@Service
public class OrderService {
    
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order getById(Integer id) {
        return orderRepository.findById(id).get();
    }
}
