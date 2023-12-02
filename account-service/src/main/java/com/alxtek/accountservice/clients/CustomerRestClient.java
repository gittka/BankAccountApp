package com.alxtek.accountservice.clients;

import com.alxtek.accountservice.model.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping("/customer/{id}")
    @CircuitBreaker(name = "customerService", fallbackMethod = "getsCustomerFallback")
    Customer findCustomerById(@PathVariable Long id);
    @GetMapping("/customers")
    @CircuitBreaker(name = "customerService", fallbackMethod = "getAllCustomersFallback")
    List<Customer> getCustomers();
    default Customer getsCustomerFallback(Long id, Exception e){
        return Customer.builder()
                .firstName("Customer Service is down")
                .lastName("Customer Service is down")
                .email("Customer Service is down")
                .build();
    }
    default List<Customer> getAllCustomersFallback(Exception e){
        return List.of(Customer.builder()
                .firstName("Customer Service is down")
                .lastName("Customer Service is down")
                .email("Customer Service is down")
                .build());
    }
}
