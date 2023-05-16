package com.springex.tutorialspringboot.repositories;

import com.springex.tutorialspringboot.dbmodels.Pet;
import com.springex.tutorialspringboot.dbmodels.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {

}

