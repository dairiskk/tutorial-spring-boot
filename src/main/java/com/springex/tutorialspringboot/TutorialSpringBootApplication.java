package com.springex.tutorialspringboot;

import com.springex.tutorialspringboot.dbmodels.Room;
import com.springex.tutorialspringboot.dbmodels.Message;
import com.springex.tutorialspringboot.dbmodels.User;
import com.springex.tutorialspringboot.repositories.RoomRepository;
import com.springex.tutorialspringboot.repositories.MessageRepository;
import com.springex.tutorialspringboot.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class TutorialSpringBootApplication {

    private Room savedRoom2;

    public static void main(String[] args) {
        SpringApplication.run(TutorialSpringBootApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(UserRepository usersR, RoomRepository roomR, MessageRepository messageR, PasswordEncoder encoder) {
        User usr1 = new User("User", encoder.encode("password"), "ROLE_USER");
        User usr2 = new User("Admin", encoder.encode("password"), "ROLE_ADMIN,ROLE_USER");
        return args -> {
            var savedUser1 = usersR.save(usr1);
            var savedUser2 = usersR.save(usr2);
            var savedRoom1 = roomR.save(new Room(savedUser1));
            var savedRoom2 = roomR.save(new Room(savedUser2));
            messageR.save(new Message("hello from user 1 in room 1", savedRoom1, usr1));
            messageR.save(new Message("hello from user 2 in room 1", savedRoom1, usr1));
            messageR.save(new Message("hello from user 1 in room 2", savedRoom2, usr1));
            messageR.save(new Message("hello from user 2 in room 2", savedRoom2, usr2));
        };
    }

}
