package com.demo.ejb.banking;

import java.math.BigDecimal;

import javax.ejb.Remote;
import javax.ejb.Singleton;

import com.demo.ejb.banking.exception.AccountExistsException;
import com.demo.ejb.banking.exception.AccountNotFoundException;
import com.demo.ejb.banking.exception.InsufficientBalanceException;

@Singleton
@Remote({TransactionService.class, AccountService.class})
public class RemoteBankingService implements TransactionService, AccountService {

	private final AccountService accountService = new InMemoryAccountService();
	private final TransactionService transactionService = new SimpleTransactionService(accountService);
	
	public void create(String name, BigDecimal balance) throws InsufficientBalanceException, AccountExistsException {
		accountService.create(name, balance);
	}

	public BigDecimal getBalance(String name) throws AccountNotFoundException {
		return accountService.getBalance(name);
	}

	public void credit(String name, BigDecimal amount) throws AccountNotFoundException {
		accountService.credit(name, amount);
	}

	public void debit(String name, BigDecimal amount) throws AccountNotFoundException, InsufficientBalanceException {
		accountService.debit(name, amount);
	}

	public void transfer(String from, String to, BigDecimal amount) throws AccountNotFoundException, InsufficientBalanceException {
		transactionService.transfer(from, to, amount);
	}

}
