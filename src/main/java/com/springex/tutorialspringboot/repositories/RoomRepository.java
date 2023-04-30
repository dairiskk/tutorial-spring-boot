package com.springex.tutorialspringboot.repositories;

import com.springex.tutorialspringboot.dbmodels.Room;
import com.springex.tutorialspringboot.dbmodels.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
    List<Room> findByUser(User user);
}

