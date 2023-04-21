package com.springex.tutorialspringboot.repositories;

import com.springex.tutorialspringboot.dbmodels.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long> {

    List<Payment> findByClientId(long id);
}

