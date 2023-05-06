package com.springex.tutorialspringboot.dbmodels;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "room")
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
    @JoinTable(
            name = "user_rooms",
            joinColumns = @JoinColumn(name = "room_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> users;
    public void setUser(User user) {
        this.users.add(user);
    }
    public Room(User user) {
        this.users = new HashSet<>();
        this.users.add(user);
        this.created = LocalDateTime.now();
    }

    public Room() {
    }
}
