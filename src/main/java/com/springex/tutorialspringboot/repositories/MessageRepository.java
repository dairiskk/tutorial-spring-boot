package com.springex.tutorialspringboot.repositories;

import com.springex.tutorialspringboot.dbmodels.Message;
import com.springex.tutorialspringboot.dbmodels.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {

    List<Message> findByUser(User user);
}

