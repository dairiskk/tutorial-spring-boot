package com.springex.tutorialspringboot.controllers;

import com.springex.tutorialspringboot.dbmodels.Account;
import com.springex.tutorialspringboot.othermodels.SecurityUser;
import com.springex.tutorialspringboot.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/account")
@PreAuthorize("hasRole('ROLE_USER')")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @PostMapping
    public Account saveAccount(Authentication authentication) {
        SecurityUser securityUser = (SecurityUser)authentication.getPrincipal();
        Account newAccount = new Account();
        newAccount.setName("LVHABA" + UUID.randomUUID());
        newAccount.setStatus("CREATED");
        newAccount.setClient(securityUser.user.getId());
        return accountRepository.save(newAccount);
    }
    @GetMapping()
    public List<Account> getUserAccounts(Authentication authentication) {
        SecurityUser securityUser = (SecurityUser)authentication.getPrincipal();
        return accountRepository.findByClient(securityUser.user.getId());
    }

}