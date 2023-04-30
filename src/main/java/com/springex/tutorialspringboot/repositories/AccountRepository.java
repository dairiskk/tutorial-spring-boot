package com.springex.tutorialspringboot.repositories;

import com.springex.tutorialspringboot.dbmodels.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
    List<Account> findByClient(long id);
}

