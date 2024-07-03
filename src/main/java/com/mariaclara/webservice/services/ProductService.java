package com.mariaclara.webservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mariaclara.webservice.entities.Product;
import com.mariaclara.webservice.repositories.ProductRepository;
import com.mariaclara.webservice.services.exceptions.ResourceNotFoundException;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product getById(Integer id) {
        Optional<Product> prod = productRepository.findById(id);
        return prod.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
