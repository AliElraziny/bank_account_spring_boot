package com.trycoding.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trycoding.banking.entity.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {

}
