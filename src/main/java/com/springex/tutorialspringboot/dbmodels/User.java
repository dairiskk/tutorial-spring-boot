package com.springex.tutorialspringboot.dbmodels;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;


@Entity
@Table(name = "users")
public class User {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private String uuid = UUID.randomUUID().toString();
    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    @JsonManagedReference
    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Room> rooms;

    @Getter
    @Setter
    @JsonManagedReference
    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Message> messages;
    @Getter
    @Setter
    private String roles;

    @Getter
    @Setter
    private boolean accountNonExpired = true;;
    @Getter
    @Setter
    private boolean accountNonLocked = true;;
    @Getter
    @Setter
    private boolean credentialsNonExpired = true;;
    @Getter
    @Setter
    private boolean enabled = true;

    @Getter
    @Setter
    private LocalDateTime created = LocalDateTime.now();

    public User(String username, String password, String roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }


    public User() {

    }

}