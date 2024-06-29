package com.mariaclara.webservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mariaclara.webservice.dtos.UserRecordDTO;
import com.mariaclara.webservice.entities.User;
import com.mariaclara.webservice.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserService service;

    @PostMapping("/save")
    public ResponseEntity<User> registerUser(@RequestBody @Valid UserRecordDTO userDto) {
        return ResponseEntity.ok().body(service.registerUser(userDto));
    }
    
}
