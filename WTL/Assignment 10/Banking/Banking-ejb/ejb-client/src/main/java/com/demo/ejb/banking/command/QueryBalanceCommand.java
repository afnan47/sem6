package com.demo.ejb.banking.command;

import java.math.BigDecimal;
import java.util.concurrent.Callable;

import com.demo.ejb.Ejb;
import com.demo.ejb.banking.AccountService;
import com.demo.ejb.banking.exception.AccountNotFoundException;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "query-balance", description = "print balance for an account", mixinStandardHelpOptions = true)
public class QueryBalanceCommand implements Callable<String> {

	@Option(names = {"name"}, description = "Name of account holder")
	private String name;

	@Override
	public String call() throws Exception {
		try {
			final AccountService accountService = Ejb.lookup("global/ejb-remote-0.0.1-SNAPSHOT/RemoteBankingService!com.demo.ejb.banking.AccountService", AccountService.class);
			final BigDecimal balance = accountService.getBalance(name);
			return String.format("Balance for account %s is %s", name, String.valueOf(balance.doubleValue()));
		} catch(AccountNotFoundException e) {
			return String.format("There is no account with name %s", name);
		}
	}
	
}
