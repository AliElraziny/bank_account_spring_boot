package com.trycoding.banking.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trycoding.banking.entity.Account;
import com.trycoding.banking.service.AccountService;
import com.trycoding.banking.service.impl.AccountServiceImpl;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
	@Autowired
	private AccountServiceImpl accountServiceImpl ; 
	
	@GetMapping("/{id}")
	public Account getAccount(@PathVariable Long id ) {
		
		return accountServiceImpl.findAccount(id);
	}
	
	@GetMapping("/")
	public List<Account> getAccounts( ) {
		
		return accountServiceImpl.findAccounts();
	}
	@PostMapping("/insert")
	public Account insert(@RequestBody Account account) {
		
		return accountServiceImpl.insert(account);
	}
	
	@PutMapping("/{id}/deposit")
	public Account deposit(@PathVariable Long id ,@RequestBody Map<String ,Double> amount) {
		
		
		return accountServiceImpl.deposit(id , amount.get("amount"));
	}
	
	@PutMapping("/{id}/withdraw")
	public Account withdraw(@PathVariable Long  id ,@RequestBody Map<String ,Double> amount) {
		
		return accountServiceImpl.withdraw(id ,amount.get("amount"));
	}
	
	@DeleteMapping("/{id}")
	public String delete( @PathVariable Long id ) {
		
		return accountServiceImpl.deleteAccount(id);
	}

}
