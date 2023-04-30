package com.springex.tutorialspringboot.controllers;

import com.springex.tutorialspringboot.dbmodels.Room;
import com.springex.tutorialspringboot.othermodels.SecurityUser;
import com.springex.tutorialspringboot.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/chatroom")
@PreAuthorize("hasRole('ROLE_USER')")
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;


    @PostMapping
    public Room save(Authentication authentication) {
        SecurityUser securityUser = (SecurityUser)authentication.getPrincipal();
        return roomRepository.save(new Room(securityUser.user));
    }

    @GetMapping()
    public List<Room> getAll(Authentication authentication) {
        SecurityUser securityUser = (SecurityUser)authentication.getPrincipal();
       return roomRepository.findByUser(securityUser.user);

    }
    @GetMapping("/{id}")
    public Stream<Room> getOne(Authentication authentication, @PathVariable(value = "id") long id) {
        SecurityUser securityUser = (SecurityUser)authentication.getPrincipal();
        List<Room> clientRooms= roomRepository.findByUser(securityUser.user);
      return clientRooms.stream().filter(x->x.getId()==id);

    }
    @PostMapping("/join/{id}")
    public Room join(Authentication authentication, @PathVariable(value = "id") long id) {
        return null;
    }

    @PostMapping("/quit/{id}")
    public Room quit(Authentication authentication, @PathVariable(value = "id") long id) {
        return null;
    }
}