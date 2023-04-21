package com.springex.tutorialspringboot.repositories;

import com.springex.tutorialspringboot.dbmodels.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);
}

