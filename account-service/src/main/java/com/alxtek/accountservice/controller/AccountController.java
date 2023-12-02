package com.alxtek.accountservice.controller;

import com.alxtek.accountservice.dto.BankAccountDtoResponse;
import com.alxtek.accountservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController @RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;
    @GetMapping("/accounts")
    @ResponseStatus(HttpStatus.OK)
    public List<BankAccountDtoResponse> accountList(){
        return accountService.accountList();
    }
    @GetMapping("/account/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BankAccountDtoResponse getAccount(@PathVariable String id){
        return accountService.getAccount(id);
    }

}
