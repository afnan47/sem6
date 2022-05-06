package com.demo.ejb.banking;

import java.math.BigDecimal;

import javax.ejb.Remote;

import com.demo.ejb.banking.exception.AccountNotFoundException;
import com.demo.ejb.banking.exception.InsufficientBalanceException;

@Remote
public interface TransactionService {

	void transfer(String from, String to, BigDecimal amount) throws AccountNotFoundException, InsufficientBalanceException;

}