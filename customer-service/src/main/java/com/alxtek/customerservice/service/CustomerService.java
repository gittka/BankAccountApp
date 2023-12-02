package com.alxtek.customerservice.service;

import com.alxtek.customerservice.dto.CustomerDtoResponse;
import com.alxtek.customerservice.entities.Customer;
import com.alxtek.customerservice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public List<CustomerDtoResponse> customerList() {
        return customerRepository.findAll().stream().map(customer -> CustomerDtoResponse.builder()
                        .firstName(customer.getFirstName())
                        .lastName(customer.getLastName())
                        .email(customer.getEmail())
                        .build())
                .toList();
    }

    public CustomerDtoResponse getCustomer(Long id) {
        return customerRepository.findById(id).map(customer -> CustomerDtoResponse.builder()
                        .firstName(customer.getFirstName())
                        .lastName(customer.getLastName())
                        .email(customer.getEmail())
                        .build())
                .orElseThrow();
    }
}
