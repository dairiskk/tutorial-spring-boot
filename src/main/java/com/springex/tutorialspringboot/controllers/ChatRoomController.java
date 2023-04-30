package com.springex.tutorialspringboot.controllers;

import com.springex.tutorialspringboot.dbmodels.Room;
import com.springex.tutorialspringboot.othermodels.SecurityUser;
import com.springex.tutorialspringboot.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/chatroom")
@PreAuthorize("hasRole('ROLE_USER')")
public class ChatRoomController {

    @Autowired
    private RoomRepository roomRepository;


    @PostMapping
    public Room save(Authentication authentication) {
       return null;
    }

    //    @PutMapping
//    public ChatRoom update(Authentication authentication) {
//        SecurityUser securityUser = (SecurityUser)authentication.getPrincipal();
//        securityUser.user.getId();
//        return chatRoomRepository.save(new ChatRoom(Collections.singletonList(securityUser.user.getId())));
//    }
    @GetMapping()
    public List<Room> get(Authentication authentication) {
        SecurityUser securityUser = (SecurityUser)authentication.getPrincipal();
       return roomRepository.findByUser(securityUser.user);

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