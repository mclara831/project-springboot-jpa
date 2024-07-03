package com.mariaclara.webservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mariaclara.webservice.entities.Category;
import com.mariaclara.webservice.repositories.CategoryRepository;
import com.mariaclara.webservice.services.exceptions.ResourceNotFoundException;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category getById(Integer id) {
        Optional<Category> cat = categoryRepository.findById(id);
        return cat.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
