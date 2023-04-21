package com.springex.tutorialspringboot;

import com.springex.tutorialspringboot.dbmodels.User;
import com.springex.tutorialspringboot.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class TutorialSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(TutorialSpringBootApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(UserRepository users, PasswordEncoder encoder) {
        return args -> {
            users.save(new User("User", encoder.encode("password"), "ROLE_USER"));
            users.save(new User("Admin", encoder.encode("password"), "ROLE_ADMIN,ROLE_USER"));
        };
    }

}
