package com.demo.ejb.banking;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.demo.ejb.banking.exception.AccountExistsException;
import com.demo.ejb.banking.exception.AccountNotFoundException;
import com.demo.ejb.banking.exception.InsufficientBalanceException;

public class InMemoryAccountService implements AccountService {

	private final Map<String, Account> cache = new HashMap<>();
	
	private Account findByName(String name) throws AccountNotFoundException {
		return Optional.ofNullable(cache.get(name)).orElseThrow(AccountNotFoundException::new);
	}
	
	public void create(String name, BigDecimal balance) throws AccountExistsException, InsufficientBalanceException {
		if(null != cache.get(name)) {
			throw new AccountExistsException();
		}
		if(balance.compareTo(BigDecimal.TEN) < 0) {
			throw new InsufficientBalanceException();
		}
		cache.put(name, new Account(name, balance));
	}

	public BigDecimal getBalance(String name) throws AccountNotFoundException {
		return findByName(name).getBalance();
	}
	
	public void credit(String name, BigDecimal amount) throws AccountNotFoundException {
		findByName(name).credit(amount);
	}
	
	public void debit(String name, BigDecimal amount) throws AccountNotFoundException, InsufficientBalanceException {
		final Account account = findByName(name);
		if(amount.compareTo(account.getBalance()) > 0) {
			throw new InsufficientBalanceException();
		}
		account.debit(amount);
	}
	
}
