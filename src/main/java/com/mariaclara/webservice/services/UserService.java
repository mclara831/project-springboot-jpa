package com.mariaclara.webservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.mariaclara.webservice.dtos.UserRecordDTO;
import com.mariaclara.webservice.entities.User;
import com.mariaclara.webservice.repositories.UserRepository;
import com.mariaclara.webservice.services.exceptions.DatabaseException;
import com.mariaclara.webservice.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User findById(Integer id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User registerUser(UserRecordDTO user) {
        User obj = new User(user);
        return repository.save(obj);
    }

    public User updateUser(Integer id, UserRecordDTO user) {
        try {
            User obj = findById(id);
            BeanUtils.copyProperties(user, obj);
            return repository.save(obj);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    public void deleteUser(Integer id) {
        try {
            repository.deleteById(id);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
}
