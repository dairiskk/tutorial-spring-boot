package com.springex.tutorialspringboot.dbmodels;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;


@Entity
@Table(name = "user")
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
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) //hides password from json
    private String password;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String roles;
    @Getter
    @Setter
    private String phone;
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