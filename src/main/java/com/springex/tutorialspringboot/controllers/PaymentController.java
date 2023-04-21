package com.springex.tutorialspringboot.controllers;

import com.springex.tutorialspringboot.dbmodels.Payment;
import com.springex.tutorialspringboot.othermodels.SecurityUser;
import com.springex.tutorialspringboot.repositories.PaymentRepository;
import com.springex.tutorialspringboot.rqmodels.PaymentRq;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment")
@PreAuthorize("hasRole('ROLE_USER')")
public class PaymentController {
    @Autowired
    private PaymentRepository paymentRepository;

    @GetMapping
    public List<Payment> findMyPayments(@NotNull Authentication authentication) {
        var securityUser = (SecurityUser)authentication.getPrincipal();
        return (List<Payment>) paymentRepository.findByClientId(securityUser.user.getId());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> findPaymentById(@PathVariable(value = "id") long id) {
        return null;
    }
    @PostMapping
    public Payment savePayment(@Validated @RequestBody @NotNull PaymentRq payment, @NotNull Authentication authentication) {
        SecurityUser securityUser = (SecurityUser)authentication.getPrincipal();
        Payment newpayment = new Payment();
        newpayment.setStatus("CREATED");
        newpayment.setClientId(securityUser.user.getId());
        newpayment.setAmount(payment.amount);
        newpayment.setCurrency(payment.currency);
        newpayment.setAccountFrom(payment.accountFrom);
        newpayment.setAccountTo(payment.accountTo);
        return paymentRepository.save(newpayment);
    }

}