package com.alxtek.accountservice.repository;

import com.alxtek.accountservice.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<BankAccount, String> {
}
