package com.springex.tutorialspringboot;

import com.springex.tutorialspringboot.dbmodels.ChatRoom;
import com.springex.tutorialspringboot.dbmodels.Message;
import com.springex.tutorialspringboot.dbmodels.User;
import com.springex.tutorialspringboot.repositories.ChatRoomRepository;
import com.springex.tutorialspringboot.repositories.MessageRepository;
import com.springex.tutorialspringboot.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class TutorialSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(TutorialSpringBootApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(UserRepository users, ChatRoomRepository crr, MessageRepository ms, PasswordEncoder encoder) {

        var participants = new ChatRoom();
        participants.setParticipantsId(Collections.singletonList(1L));
        return args -> {
            users.save(new User("User", encoder.encode("password"), "ROLE_USER"));
            users.save(new User("Admin", encoder.encode("password"), "ROLE_ADMIN,ROLE_USER"));
            crr.save(new ChatRoom(Collections.singletonList(1L)));
            ms.save(new Message(1,1, "message text"));
        };
    }

}
