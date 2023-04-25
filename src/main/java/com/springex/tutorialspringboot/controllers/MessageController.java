package com.springex.tutorialspringboot.controllers;

import com.springex.tutorialspringboot.dbmodels.Account;
import com.springex.tutorialspringboot.dbmodels.ChatRoom;
import com.springex.tutorialspringboot.dbmodels.Message;
import com.springex.tutorialspringboot.othermodels.SecurityUser;
import com.springex.tutorialspringboot.repositories.AccountRepository;
import com.springex.tutorialspringboot.repositories.ChatRoomRepository;
import com.springex.tutorialspringboot.repositories.MessageRepository;
import com.springex.tutorialspringboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/message")
@PreAuthorize("hasRole('ROLE_USER')")
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private ChatRoomRepository chatRoomRepository;


    @PostMapping
    public Message save(@RequestBody Message msg, Authentication authentication) {
        SecurityUser securityUser = (SecurityUser)authentication.getPrincipal();
        if(!chatRoomRepository.findById(msg.getChatRoomId()).get().getParticipantsId().contains(securityUser.user.getId())){
            throw new RuntimeException("not allowed");
        } else {        return messageRepository.save(new Message(msg.getChatRoomId(), securityUser.user.getId(), msg.getMessageText()));
        }

    }

    @GetMapping("/{id}")
    public List<Message> get(@PathVariable(value = "id") long chatRoomId, Authentication authentication) throws Exception {
        SecurityUser securityUser = (SecurityUser)authentication.getPrincipal();
        Optional<ChatRoom> room = chatRoomRepository.findById(chatRoomId);
        if(room.isEmpty()||!room.get().getParticipantsId().contains(securityUser.user.getId())){
            throw new Exception("chat room does not exist");
        } else {
            messageRepository.findByChatRoomId(room.get().getId());
        }
        return messageRepository.findByChatRoomId(chatRoomId);
    }

}