package com.springex.tutorialspringboot.controllers;

import com.springex.tutorialspringboot.dbmodels.ChatRoom;
import com.springex.tutorialspringboot.dbmodels.Message;
import com.springex.tutorialspringboot.othermodels.SecurityUser;
import com.springex.tutorialspringboot.repositories.ChatRoomRepository;
import com.springex.tutorialspringboot.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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
        SecurityUser securityUser = (SecurityUser) authentication.getPrincipal();
        var room = chatRoomRepository.findById(msg.getChatRoomId());
        if (room.isEmpty())
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not a part of chat room");
        if (!chatRoomRepository.findById(msg.getChatRoomId()).get().getParticipantsId()
                .contains(securityUser.user.getId())) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not a part of chat room");
        } else {
            return messageRepository
                    .save(new Message(msg.getChatRoomId(), securityUser.user.getId(), msg.getMessageText()));
        }

    }

    @GetMapping("/{id}")
    public List<Message> get(@PathVariable(value = "id") long chatRoomId, Authentication authentication)
            throws Exception {
        SecurityUser securityUser = (SecurityUser) authentication.getPrincipal();
        Optional<ChatRoom> room = chatRoomRepository.findById(chatRoomId);
        if (room.isEmpty() || !room.get().getParticipantsId().contains(securityUser.user.getId())) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not a part of chat room");
        } else {
            return messageRepository.findByChatRoomId(room.get().getId());
        }

    }

}