package com.springex.tutorialspringboot.repositories;

import com.springex.tutorialspringboot.dbmodels.ChatRoom;
import com.springex.tutorialspringboot.dbmodels.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ChatRoomRepository extends CrudRepository<ChatRoom, Long> {
}

