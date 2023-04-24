package com.springex.tutorialspringboot.controllers;

import com.springex.tutorialspringboot.dbmodels.Account;
import com.springex.tutorialspringboot.dbmodels.ChatRoom;
import com.springex.tutorialspringboot.dbmodels.Message;
import com.springex.tutorialspringboot.othermodels.SecurityUser;
import com.springex.tutorialspringboot.repositories.ChatRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/chatroom")
@PreAuthorize("hasRole('ROLE_USER')")
public class ChatRoomController {

    @Autowired
    private ChatRoomRepository chatRoomRepository;


    @PostMapping
    public ChatRoom save(Authentication authentication) {
        SecurityUser securityUser = (SecurityUser)authentication.getPrincipal();
        securityUser.user.getId();
        return chatRoomRepository.save(new ChatRoom(Collections.singletonList(securityUser.user.getId())));
    }
//    @PutMapping
//    public ChatRoom update(Authentication authentication) {
//        SecurityUser securityUser = (SecurityUser)authentication.getPrincipal();
//        securityUser.user.getId();
//        return chatRoomRepository.save(new ChatRoom(Collections.singletonList(securityUser.user.getId())));
//    }
    @GetMapping()
    public Optional<ChatRoom> get(Authentication authentication) {
        SecurityUser securityUser = (SecurityUser)authentication.getPrincipal();
        return chatRoomRepository.findById(securityUser.user.getId());
    }

}