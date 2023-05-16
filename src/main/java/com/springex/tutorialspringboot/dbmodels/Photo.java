package com.springex.tutorialspringboot.dbmodels;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "photo")
public class Photo {
    public Photo() {
    }

    public Photo(User user) {
        this.user = user;
    }

    public Photo(Pet pet) {
        this.pet = pet;
    }

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Getter
    @Setter
    private Byte[] photo;
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    @ManyToOne
    private User user;

    @Getter
    @Setter
    @ManyToOne
    private Pet pet;
}
