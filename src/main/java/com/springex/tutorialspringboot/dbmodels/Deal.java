package com.springex.tutorialspringboot.dbmodels;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "deal")
public class Deal {
    public Deal() {
    }

    public Deal(User owner) {
        this.owner = owner;
    }

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Getter
    @Setter
    @ManyToOne
    private Pet pet;

    @Getter
    @Setter
    private Date dateFrom;
    @Getter
    @Setter
    private Date dateTo;
    @Getter
    @Setter
    private String location;

    @Getter
    @Setter
    @ManyToOne
    private User owner;

    @Getter
    @Setter
    @ManyToOne
    private User helper;
}
