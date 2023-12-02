package com.alxtek.accountservice.entities;

import com.alxtek.accountservice.enums.AccountType;
import com.alxtek.accountservice.model.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor @Builder
public class BankAccount {
    @Id
    private String accountID;
    private double balance;
    private LocalDate dateCreated;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    private Long customerID;
    @Transient
    private Customer customer;
}
