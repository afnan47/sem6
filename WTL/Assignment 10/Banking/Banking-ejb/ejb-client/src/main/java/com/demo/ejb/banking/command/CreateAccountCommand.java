package com.demo.ejb.banking.command;

import java.math.BigDecimal;
import java.util.concurrent.Callable;

import com.demo.ejb.Ejb;
import com.demo.ejb.banking.AccountService;
import com.demo.ejb.banking.exception.AccountExistsException;
import com.demo.ejb.banking.exception.InsufficientBalanceException;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name ="create-account", description = "Create an account", mixinStandardHelpOptions = true)
public class CreateAccountCommand implements Callable<String> {

	@Option(names = {"amount"}, description = "Initial amount in the account")
	private String amount;
	
	@Option(names = {"name"}, description = "Name of account holder")
	private String name;

	@Override
	public String call() throws Exception {
		try {
			final AccountService accountService = Ejb.lookup("global/ejb-remote-0.0.1-SNAPSHOT/RemoteBankingService!com.demo.ejb.banking.AccountService", AccountService.class);
			accountService.create(name, new BigDecimal(amount));
		} catch(NumberFormatException e) {
			return String.format("%s is not a valid number", amount);
		} catch(AccountExistsException e) {
			return String.format("Account with name %s already exists", name);
		} catch(InsufficientBalanceException e) {
			return String.format("%s is insufficient for initial balance, minimum should be 10", amount);
		}
		return String.format("Account %s created with initial balance %s", name, amount);
	}
	
}
