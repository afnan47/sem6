package com.demo.ejb.banking;

import java.math.BigDecimal;

import javax.ejb.Remote;

import com.demo.ejb.banking.exception.AccountExistsException;
import com.demo.ejb.banking.exception.AccountNotFoundException;
import com.demo.ejb.banking.exception.InsufficientBalanceException;

@Remote
public interface AccountService {

	void create(String name, BigDecimal balance) throws AccountExistsException, InsufficientBalanceException;

	BigDecimal getBalance(String name) throws AccountNotFoundException;

	void credit(String name, BigDecimal amount) throws AccountNotFoundException;

	void debit(String name, BigDecimal amount) throws AccountNotFoundException, InsufficientBalanceException;

}