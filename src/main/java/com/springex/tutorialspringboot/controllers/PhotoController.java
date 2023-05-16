package com.springex.tutorialspringboot.controllers;

import com.springex.tutorialspringboot.dbmodels.Pet;
import com.springex.tutorialspringboot.dbmodels.Photo;
import com.springex.tutorialspringboot.repositories.PetRepository;
import com.springex.tutorialspringboot.repositories.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@PreAuthorize("hasRole('ROLE_USER')")
@RequestMapping("/api/photo")
public class PhotoController {

    @Autowired
    private PhotoRepository photoRepository;

    @GetMapping
    public List<Photo> findAllUsers() {
        return photoRepository.findAll();
    }
}