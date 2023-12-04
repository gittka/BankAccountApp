package com.alxtek.accountservice;

import com.alxtek.accountservice.clients.CustomerRestClient;
import com.alxtek.accountservice.entities.BankAccount;
import com.alxtek.accountservice.enums.AccountType;
import com.alxtek.accountservice.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(AccountRepository accountRepository, CustomerRestClient customerRestClient) {
        return args -> customerRestClient.getCustomers().forEach(customer -> {
            BankAccount account =  BankAccount.builder().
                    accountID(UUID.randomUUID().toString()).
                    accountType(AccountType.CURRENT_ACCOUNT).
                    currency("USD").
                    customerID(customer.getId()).
                    balance(Math.random() * 1000)
                    .dateCreated(LocalDate.now())
                    .build();

            BankAccount account2 =  BankAccount.builder().
                    accountID(UUID.randomUUID().toString()).
                    accountType(AccountType.SAVING_ACCOUNT).
                    currency("USD").
                    customerID(customer.getId()).
                    balance(Math.random() * 1000)
                    .dateCreated(LocalDate.now())
                    .build();

            accountRepository.save(account);
            accountRepository.save(account2);
        });
    }

}
