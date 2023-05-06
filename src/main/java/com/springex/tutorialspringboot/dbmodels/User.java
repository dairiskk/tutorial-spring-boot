package com.springex.tutorialspringboot.dbmodels;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;


@Entity
@Table(name = "user")
public class User {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @JsonIgnore
    private String uuid = UUID.randomUUID().toString();
    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String password;

    @ManyToMany(mappedBy = "users")
    @Getter
    @Setter
    @JsonIgnore
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
    @JsonIgnore
    private String roles;

    @Getter
    @Setter
    @JsonIgnore
    private boolean accountNonExpired = true;
    @Getter
    @Setter
    @JsonIgnore
    private boolean accountNonLocked = true;
    @Getter
    @Setter
    @JsonIgnore
    private boolean credentialsNonExpired = true;
    @Getter
    @Setter
    @JsonIgnore
    private boolean enabled = true;

    @Getter
    @Setter
    @JsonIgnore
    private LocalDateTime created = LocalDateTime.now();

    public User(String username, String password, String roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }


    public User() {

    }

    @Override
    public String toString() {
        return this.getUsername();
    }
}