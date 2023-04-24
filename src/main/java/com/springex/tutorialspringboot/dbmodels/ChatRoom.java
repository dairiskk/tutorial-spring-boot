package com.springex.tutorialspringboot.dbmodels;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "chat_room")
public class ChatRoom {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Getter
    @Setter
    private List<Long> participantsId;

    @Getter
    @Setter
    private LocalDateTime created;

    public ChatRoom(List<Long> participantsId) {
        this.participantsId = participantsId;
        this.created = LocalDateTime.now();
    }
}
