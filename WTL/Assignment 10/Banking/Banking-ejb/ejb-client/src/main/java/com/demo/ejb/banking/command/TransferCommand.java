package com.demo.ejb.banking.command;

import java.math.BigDecimal;
import java.util.concurrent.Callable;

import com.demo.ejb.Ejb;
import com.demo.ejb.banking.TransactionService;
import com.demo.ejb.banking.exception.AccountNotFoundException;
import com.demo.ejb.banking.exception.InsufficientBalanceException;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "transfer", description = "transfer an amount from one acount to other", mixinStandardHelpOptions = true)
public class TransferCommand implements Callable<String> {
	
	@Option(names = {"amount"}, description = "Initial amount to credit")
	private String amount;
	
	@Option(names = {"from"}, description = "Name of account from where amount is to be transferred")
	private String from;

	@Option(names = {"to"}, description = "Name of account to where amount is to be transferred")
	private String to;

	@Override
	public String call() throws Exception {
		try {
			final TransactionService transactionService = Ejb.lookup("global/ejb-remote-0.0.1-SNAPSHOT/RemoteBankingService!com.demo.ejb.banking.TransactionService", TransactionService.class);
			transactionService.transfer(from, to, new BigDecimal(amount));
		} catch(AccountNotFoundException e) {
			return String.format("There is no account with name %s or %s", from, to);
		} catch(NumberFormatException e) {
			return String.format("%s is not a valid number", amount);
		} catch(InsufficientBalanceException e) {
			return String.format("Account %s has insufficient balance for debit of %s amount", from, amount);
		}
		return String.format("Amount %s transferred from %s to %s", amount, from, to);
	}
	
}
