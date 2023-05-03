package com.springex.tutorialspringboot.dbmodels;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
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
    private String messageText;

    @Getter
    @Setter
    private LocalDateTime created;

    @Getter
    @Setter
    @JsonIgnore
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "room_id", nullable = true)
    private Room room;

    @Getter
    @Setter
    @JsonIgnore
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Message() {

    }

    public Message(String messageText, Room room, User user) {
        this.messageText = messageText;
        this.created = LocalDateTime.now();
        this.room = room;
        this.user = user;
    }
}
