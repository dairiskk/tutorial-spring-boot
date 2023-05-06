package com.springex.tutorialspringboot.controllers;

import com.springex.tutorialspringboot.dbmodels.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class SocketMessages {
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Message greeting(Message message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Message(HtmlUtils.htmlEscape(message.getMessageText()));
    }
}
