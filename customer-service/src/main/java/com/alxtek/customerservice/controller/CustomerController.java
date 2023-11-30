package com.alxtek.customerservice.controller;

import com.alxtek.customerservice.entities.Customer;
import com.alxtek.customerservice.repository.CustomerRepository;
import com.alxtek.customerservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CustomerController {
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> customerList(){
        return customerService.customerList();
    }

    @GetMapping("/customer/{id}")
    public Customer getCustomer(@PathVariable Long id){
        return customerService.getCustomer(id);
    }


}
