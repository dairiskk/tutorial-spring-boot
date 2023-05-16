package com.springex.tutorialspringboot.dbmodels;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "pet")
public class Pet {
    public Pet() {
    }

    public Pet(String name, User user) {
        this.name = name;
        this.user = user;
    }

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String type;
    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    @ManyToOne
    private User user;
}
