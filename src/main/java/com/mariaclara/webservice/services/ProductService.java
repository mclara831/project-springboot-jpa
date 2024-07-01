package com.mariaclara.webservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mariaclara.webservice.entities.Product;
import com.mariaclara.webservice.repositories.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product getById(Integer id) {
        return productRepository.findById(id).get();
    }
}
