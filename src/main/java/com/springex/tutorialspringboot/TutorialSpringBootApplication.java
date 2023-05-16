package com.springex.tutorialspringboot;

import com.springex.tutorialspringboot.dbmodels.Deal;
import com.springex.tutorialspringboot.dbmodels.Pet;
import com.springex.tutorialspringboot.dbmodels.Photo;
import com.springex.tutorialspringboot.dbmodels.User;
import com.springex.tutorialspringboot.repositories.DealRepository;
import com.springex.tutorialspringboot.repositories.PetRepository;
import com.springex.tutorialspringboot.repositories.PhotoRepository;
import com.springex.tutorialspringboot.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableScheduling
public class TutorialSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(TutorialSpringBootApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(UserRepository usersR, DealRepository dealRepository, PasswordEncoder encoder, PhotoRepository photoRepository, PetRepository petR) {
        User usr1 = new User("User", encoder.encode("password"), "ROLE_USER");
        User usr2 = new User("Admin", encoder.encode("password"), "ROLE_ADMIN,ROLE_USER");
        Pet pet1 = new Pet("name of pet", usr1);
        Pet pet2 = new Pet("name of pet", usr2);
        Photo photo1 = new Photo(usr1);
        Photo photo2 = new Photo(pet1);
        Deal deal1 = new Deal(usr1);
        Deal deal2 = new Deal(usr2);
        return args -> {
            usersR.save(usr1);
            usersR.save(usr2);
            petR.save(pet1);
            petR.save(pet2);
            photoRepository.save(photo1);
            photoRepository.save(photo2);
            dealRepository.save(deal1);
            dealRepository.save(deal2);

        };
    }

}
