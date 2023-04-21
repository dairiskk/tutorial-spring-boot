package com.springex.tutorialspringboot.rqmodels;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


public class PaymentRq {
    public String currency;
    public String amount;
    public String accountFrom;
    public String accountTo;
}
