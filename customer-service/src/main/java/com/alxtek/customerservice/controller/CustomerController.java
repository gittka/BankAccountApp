package com.alxtek.customerservice.controller;

import com.alxtek.customerservice.dto.CustomerDtoResponse;
import com.alxtek.customerservice.entities.Customer;
import com.alxtek.customerservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerDtoResponse> customerList(){
        return customerService.customerList();
    }

    @GetMapping("/customer/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDtoResponse getCustomer(@PathVariable Long id){
        return customerService.getCustomer(id);
    }


}
