package com.alxtek.accountservice.dto;

import com.alxtek.accountservice.enums.AccountType;
import com.alxtek.accountservice.model.Customer;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter @Setter @Builder
public class BankAccountDtoResponse {
    private String accountID;
    private double balance;
    private LocalDate dateCreated;
    private String currency;
    private AccountType accountType;
    private Long customerID;

    private Customer customer;
}
