package com.alxtek.customerservice;

import com.alxtek.customerservice.config.GlobalConfig;
import com.alxtek.customerservice.entities.Customer;
import com.alxtek.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner runner(CustomerRepository customerRepository) {
		return args -> {
			customerRepository.save(Customer.builder()
					.id(1L)
					.firstName("Alex")
					.lastName("Tek")
					.email("J5sDg@example.com")
					.build());
			customerRepository.save(Customer.builder()
					.id(2L)
					.firstName("John")
					.lastName("Doe")
					.email("nHbJi@example.com")
					.build());
			customerRepository.save(Customer.builder()
					.id(3L)
					.firstName("Jane")
					.lastName("Doe")
					.email("wJfJt@example.com")
					.build());
		};
	}
}
