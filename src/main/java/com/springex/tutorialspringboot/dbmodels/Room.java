package com.springex.tutorialspringboot.dbmodels;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Getter
    @Setter
    private LocalDateTime created;


    @Getter
    @Setter
    @JsonManagedReference
    @JsonIgnore
    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Message> messages;

    @ManyToMany
    @Getter
    @JsonIgnore
    private Set<User> user;
    public void setUser(User user) {
        this.user.add(user);
    }
    public Room(User user) {
        this.user = new HashSet<>();
        this.user.add(user);
        this.created = LocalDateTime.now();
    }

    public Room() {
    }
}
