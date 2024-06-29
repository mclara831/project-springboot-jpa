package com.mariaclara.webservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mariaclara.webservice.dtos.UserRecordDTO;
import com.mariaclara.webservice.entities.User;
import com.mariaclara.webservice.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;

    public User registerUser(UserRecordDTO user) {
        User obj = new User(user);
        return repository.save(obj);
    }

}
