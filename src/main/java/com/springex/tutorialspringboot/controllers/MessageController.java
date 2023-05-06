package com.springex.tutorialspringboot.controllers;

import com.springex.tutorialspringboot.HttpResponseMessages;
import com.springex.tutorialspringboot.dbmodels.Message;
import com.springex.tutorialspringboot.dbmodels.Room;
import com.springex.tutorialspringboot.othermodels.SecurityUser;
import com.springex.tutorialspringboot.repositories.RoomRepository;
import com.springex.tutorialspringboot.repositories.MessageRepository;
import com.springex.tutorialspringboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/message")
@PreAuthorize("hasRole('ROLE_USER')")
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/{roomId}")
    public List<Message> get(@PathVariable(value = "id") long roomId, Authentication authentication) throws Exception {
        return null;
    }
    @PostMapping("/{id}")
    public Message post(@PathVariable(value = "id") long id, @RequestBody Message message, Authentication authentication) throws Exception {
        SecurityUser securityUser = (SecurityUser) authentication.getPrincipal();
       Room messageRoom = securityUser.user.getRooms().stream().filter(x->x.getId()==id).findFirst().orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, HttpResponseMessages.VALUE_NOT_FOUND));
        return messageRepository.save(new Message(message.getMessageText(), messageRoom, securityUser.user));
    }


    @GetMapping("")
    public List<Message> get(Authentication authentication) throws Exception {
        SecurityUser securityUser = (SecurityUser) authentication.getPrincipal();
        return messageRepository.findByUser(securityUser.user);
    }

}