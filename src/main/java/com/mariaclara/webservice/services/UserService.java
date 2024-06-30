package com.mariaclara.webservice.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mariaclara.webservice.dtos.UserRecordDTO;
import com.mariaclara.webservice.entities.User;
import com.mariaclara.webservice.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;

    public List<User> getAllUsers(){
        return repository.findAll();
    }

    public User findById(Integer id) {
        return repository.findById(id).get();
    }

    public User registerUser(UserRecordDTO user) {
        User obj = new User(user);
        return repository.save(obj);
    }

    public User updateUser(Integer id, UserRecordDTO user) {
        User obj = findById(id);
        BeanUtils.copyProperties(user, obj);
        return repository.save(obj);
    }

    public void deleteUser(Integer id) {
        repository.deleteById(id);
    }

}
