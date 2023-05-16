package com.springex.tutorialspringboot.controllers;

import com.springex.tutorialspringboot.dbmodels.Pet;
import com.springex.tutorialspringboot.dbmodels.User;
import com.springex.tutorialspringboot.repositories.PetRepository;
import com.springex.tutorialspringboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@PreAuthorize("hasRole('ROLE_USER')")
@RequestMapping("/api/pet")
public class PetController {

    @Autowired
    private PetRepository petRepository;

    @GetMapping
    public List<Pet> findAllUsers() {
        return petRepository.findAll();
    }
}