package com.demo.ejb.banking;

import java.math.BigDecimal;
import java.util.Objects;

import com.demo.ejb.banking.exception.AccountNotFoundException;
import com.demo.ejb.banking.exception.InsufficientBalanceException;

public class SimpleTransactionService implements TransactionService {

	private final AccountService accountService;
	
	public SimpleTransactionService(AccountService accountService) {
		Objects.requireNonNull(accountService);
		this.accountService = accountService;
	}
	
	public void transfer(String from, String to, BigDecimal amount) throws AccountNotFoundException, InsufficientBalanceException {
		accountService.debit(from, amount);
		accountService.credit(to, amount);
	}
	
}
