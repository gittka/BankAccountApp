package com.alxtek.customerservice.service;

import com.alxtek.customerservice.entities.Customer;
import com.alxtek.customerservice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    public List<Customer> customerList() {
    }
}
