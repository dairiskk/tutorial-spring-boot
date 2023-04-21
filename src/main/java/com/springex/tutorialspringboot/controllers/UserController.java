package com.springex.tutorialspringboot.controllers;

import com.springex.tutorialspringboot.dbmodels.User;
import com.springex.tutorialspringboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@PreAuthorize("hasRole('ROLE_USER')")
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> findAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> findUserById(@PathVariable(value = "id") long id) {
        return userRepository.findById(id);
    }
    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public User saveUser(@RequestBody @Validated User user) {
        return userRepository.save(user);
    }
}