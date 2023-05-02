package com.springex.tutorialspringboot.repositories;

import com.springex.tutorialspringboot.dbmodels.Room;
import com.springex.tutorialspringboot.dbmodels.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;


@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
    List<Room> findByUsers(User user);

//    @Transactional
//    @Modifying
//    @Query("update rooms r set r.users = ?1 where r.id = ?2")
//    void updateRoomUser(Set<User> user, Long id);
}

