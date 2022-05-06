package com.demo.ejb.banking.command;

import java.math.BigDecimal;
import java.util.concurrent.Callable;

import com.demo.ejb.Ejb;
import com.demo.ejb.banking.AccountService;
import com.demo.ejb.banking.exception.AccountNotFoundException;
import com.demo.ejb.banking.exception.InsufficientBalanceException;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "debit", description = "Debit amount from an account", mixinStandardHelpOptions = true)
public class DebitCommand implements Callable<String> {

	@Option(names = {"amount"}, description = "Initial amount to credit")
	private String amount;
	
	@Option(names = {"name"}, description = "Name of account holder")
	private String name;

	@Override
	public String call() throws Exception {
		try {
			final AccountService accountService = Ejb.lookup("global/ejb-remote-0.0.1-SNAPSHOT/RemoteBankingService!com.demo.ejb.banking.AccountService", AccountService.class);
			accountService.debit(name, new BigDecimal(amount));
		} catch(AccountNotFoundException e) {
			return String.format("There is no account with name %s", name);
		} catch(NumberFormatException e) {
			return String.format("%s is not a valid number", amount);
		} catch(InsufficientBalanceException e) {
			return String.format("Account %s has insufficient balance for debit of %s amount", name, amount);
		}
		return String.format("Account %s is debited with amount %s", name, amount);
	}
	
}
