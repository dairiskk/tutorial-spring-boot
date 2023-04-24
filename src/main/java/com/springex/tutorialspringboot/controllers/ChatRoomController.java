package com.springex.tutorialspringboot.controllers;

import com.springex.tutorialspringboot.dbmodels.ChatRoom;
import com.springex.tutorialspringboot.othermodels.SecurityUser;
import com.springex.tutorialspringboot.repositories.ChatRoomRepository;
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
    public List<ChatRoom> get(Authentication authentication) {
        SecurityUser securityUser = (SecurityUser)authentication.getPrincipal();
        List<ChatRoom> allChatRooms = (List<ChatRoom>) chatRoomRepository.findAll();
        var r =allChatRooms.stream().filter(chatRoom -> chatRoom.getParticipantsId().contains(securityUser.user.getId()));
        return r.toList();
    }

    @PostMapping("/join/{id}")
    public ChatRoom join(Authentication authentication, @PathVariable(value = "id") long id) {
        SecurityUser securityUser = (SecurityUser)authentication.getPrincipal();
        List<Long> participants = chatRoomRepository.findById(id).get().getParticipantsId();
        if(!participants.contains(securityUser.user.getId())){
            participants.add(securityUser.user.getId());
            ChatRoom chatToUpdate = chatRoomRepository.findById(id).get();
            chatToUpdate.setParticipantsId(participants);
            return chatRoomRepository.save(chatToUpdate);
        } else throw new RuntimeException("Already in chat room");
    }
    @PostMapping("/quit/{id}")
    public ChatRoom quit(Authentication authentication, @PathVariable(value = "id") long id) {
        SecurityUser securityUser = (SecurityUser)authentication.getPrincipal();
        List<Long> participants = chatRoomRepository.findById(id).get().getParticipantsId();
            participants.remove(securityUser.user.getId());
            ChatRoom chatToUpdate = chatRoomRepository.findById(id).get();
            chatToUpdate.setParticipantsId(participants);
            return chatRoomRepository.save(chatToUpdate);
    }
}