package com.springex.tutorialspringboot.dbmodels;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Getter
    @Setter
    private String status;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private long client;
    @Getter
    @Setter
    private LocalDateTime created = LocalDateTime.now();
    public Account() {
    }
}
