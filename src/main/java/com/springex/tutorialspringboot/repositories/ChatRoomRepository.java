package com.springex.tutorialspringboot.repositories;

import com.springex.tutorialspringboot.dbmodels.ChatRoom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ChatRoomRepository extends CrudRepository<ChatRoom, Long> {
    Optional<ChatRoom> findByParticipantsId(long id);
}

