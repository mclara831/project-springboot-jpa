package com.mariaclara.webservice.controllers;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        var list = service.getAllUsers();
        list.forEach(user -> user.add(linkTo(methodOn(UserController.class).getById(user.getId())).withSelfRel()));
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Integer id){
        User aux = service.findById(id);
        aux.add(linkTo(methodOn(UserController.class).getAll()).withSelfRel());
        return ResponseEntity.ok().body(aux);
    }

    @PostMapping("/save")
    public ResponseEntity<User> registerUser(@RequestBody @Valid UserRecordDTO userDto) {
        return ResponseEntity.ok().body(service.registerUser(userDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Integer id,@RequestBody @Valid UserRecordDTO user) {
        return ResponseEntity.ok().body(service.updateUser(id, user));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        service.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}