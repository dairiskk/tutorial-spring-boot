package com.springex.tutorialspringboot.repositories;

import com.springex.tutorialspringboot.dbmodels.Room;
import com.springex.tutorialspringboot.dbmodels.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);

//    @Transactional
//    @Modifying
//    @Query("update users u set u.rooms = ?1 where u.id = ?2")
//    void updateUserRooms(Set<Room> rooms, Long id);
}

