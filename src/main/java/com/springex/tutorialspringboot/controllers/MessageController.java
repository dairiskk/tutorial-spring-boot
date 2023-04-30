package com.springex.tutorialspringboot.controllers;

import com.springex.tutorialspringboot.dbmodels.Message;
import com.springex.tutorialspringboot.repositories.RoomRepository;
import com.springex.tutorialspringboot.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/message")
@PreAuthorize("hasRole('ROLE_USER')")
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private RoomRepository chatRoomRepository;


    @PostMapping
    public Message save(@RequestBody Message msg, Authentication authentication) {
        return null;

    }

    @GetMapping("/{id}")
    public List<Message> get(@PathVariable(value = "id") long chatRoomId, Authentication authentication) throws Exception {
        return null;
    }

}