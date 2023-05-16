package com.springex.tutorialspringboot.repositories;

import com.springex.tutorialspringboot.dbmodels.Deal;
import com.springex.tutorialspringboot.dbmodels.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DealRepository extends JpaRepository<Deal, Long> {

}

