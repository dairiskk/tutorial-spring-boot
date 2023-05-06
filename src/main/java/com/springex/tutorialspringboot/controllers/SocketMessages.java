package com.springex.tutorialspringboot.controllers;

import com.springex.tutorialspringboot.dbmodels.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.util.HtmlUtils;

@Slf4j
//@Controller
public class SocketMessages {
//    @MessageMapping("/chat.register")
//    @SendTo("/topic/public")
//    public Message register(@Payload Message chatMessage, SimpMessageHeaderAccessor headerAccessor) {
//        headerAccessor.getSessionAttributes().put("username", "password");
//        return chatMessage;
//    }
//
//    @MessageMapping("/chat.send")
//    @SendTo("/topic/public")
//    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
//        return chatMessage;
//    }
}
