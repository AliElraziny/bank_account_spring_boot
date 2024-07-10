package com.trycoding.banking.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trycoding.banking.entity.Account;
import com.trycoding.banking.repository.AccountRepo;
import com.trycoding.banking.service.AccountService;


@Service
public class AccountServiceImpl implements AccountService{
	
	
	private AccountRepo accountRepo ; 
	
	
	@Autowired
	public AccountServiceImpl(AccountRepo accountRepo) {
		super();
		this.accountRepo = accountRepo;
	}

	@Override
	public Account findAccount(Long id) {
	
		return accountRepo.findById(id).orElseThrow();
	}

	@Override
	public Account insert(Account account) {
		
		return accountRepo.save(account);
	}

	@Override
	public Account deposit(Long id, double amount) {
		Account account = accountRepo.findById(id).orElseThrow();
		account.setBalance(account.getBalance()+amount) ;
		return accountRepo.save(account);
	}

	@Override
	public Account withdraw(Long id, double amount) {
		Account account = accountRepo.findById(id).orElseThrow();
		account.setBalance(account.getBalance()-amount) ;
		return accountRepo.save(account);
	}

	@Override
	public List<Account> findAccounts() {
		// TODO Auto-generated method stub
		return accountRepo.findAll();
	}

	@Override
	public String deleteAccount(Long id) {
		accountRepo.deleteById(id);
		return "deleted  "+id;
	}




	
	
	

}
