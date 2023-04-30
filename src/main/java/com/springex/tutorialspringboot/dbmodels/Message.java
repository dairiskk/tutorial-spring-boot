package com.springex.tutorialspringboot.dbmodels;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "message")
public class Message {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Getter
    @Setter
    private long chatRoomId;
    @Getter
    @Setter
    private long userId;

    @Getter
    @Setter
    private String messageText;

    @Getter
    @Setter
    private LocalDateTime created;

    public Message() {

    }

    public Message(long chatRoomId, long userId, String messageText) {
        this.chatRoomId = chatRoomId;
        this.userId = userId;
        this.messageText = messageText;
        this.created = LocalDateTime.now();
    }
}
