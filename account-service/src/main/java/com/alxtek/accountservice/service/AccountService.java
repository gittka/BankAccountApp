package com.alxtek.accountservice.service;

import com.alxtek.accountservice.clients.CustomerRestClient;
import com.alxtek.accountservice.dto.BankAccountDtoResponse;
import com.alxtek.accountservice.entities.BankAccount;
import com.alxtek.accountservice.model.Customer;
import com.alxtek.accountservice.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final CustomerRestClient customerRestClient;

    public List<BankAccountDtoResponse> accountList() {
        return accountRepository.findAll().stream().map(account -> BankAccountDtoResponse.builder()
                        .accountType(account.getAccountType())
                        .currency(account.getCurrency())
                        .dateCreated(account.getDateCreated())
                        .accountID(account.getAccountID())
                        .customerID(account.getCustomerID())
                        .customer(account.getCustomer())
                        .balance(account.getBalance())
                        .build())
                .toList();
    }

    public BankAccountDtoResponse getAccount(String id) {
        BankAccount bankAccount = accountRepository.findById(id).get();
        Customer customer = customerRestClient.findCustomerById(bankAccount.getCustomerID());
        customer.setId(bankAccount.getCustomerID());
        bankAccount.setCustomer(customer);
        return BankAccountDtoResponse.builder()
                        .accountType(bankAccount.getAccountType())
                        .currency(bankAccount.getCurrency())
                        .dateCreated(bankAccount.getDateCreated())
                        .accountID(bankAccount.getAccountID())
                        .customerID(bankAccount.getCustomerID())
                        .customer(bankAccount.getCustomer())
                        .balance(bankAccount.getBalance())
                        .build();
    }
}
