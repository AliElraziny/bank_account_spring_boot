package com.trycoding.banking.service;

import java.util.List;

import com.trycoding.banking.entity.Account;

public interface AccountService {
	
	
	public Account findAccount(Long id);
	
	public Account insert(Account account );
	
	public Account deposit(Long id  , double amount );
	
	public Account withdraw(Long id  , double amount );
	
	public List<Account> findAccounts();
	
	public String deleteAccount(Long id);
	
	

}
