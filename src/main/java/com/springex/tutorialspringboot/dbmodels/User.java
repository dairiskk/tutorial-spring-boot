package com.springex.tutorialspringboot.dbmodels;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String password;
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