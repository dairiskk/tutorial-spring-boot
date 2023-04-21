package com.springex.tutorialspringboot.dbmodels;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Getter
    @Setter
    private String status;
    @Getter
    @Setter
    private long clientId;
    @Getter
    @Setter
    private String currency;
    @Getter
    @Setter
    private String amount;
    @Getter
    @Setter
    private String accountFrom;
    @Getter
    @Setter
    private String accountTo;
    @Getter
    @Setter
    private LocalDateTime created = LocalDateTime.now();

}
