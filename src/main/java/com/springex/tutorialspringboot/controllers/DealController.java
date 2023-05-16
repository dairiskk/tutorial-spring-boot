package com.springex.tutorialspringboot.controllers;

import com.springex.tutorialspringboot.dbmodels.Deal;
import com.springex.tutorialspringboot.dbmodels.Pet;
import com.springex.tutorialspringboot.repositories.DealRepository;
import com.springex.tutorialspringboot.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@PreAuthorize("hasRole('ROLE_USER')")
@RequestMapping("/api/deal")
public class DealController {

    @Autowired
    private DealRepository dealRepository;

    @GetMapping
    public List<Deal> findAllUsers() {
        return dealRepository.findAll();
    }
}