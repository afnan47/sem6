package com.demo.ejb.banking;

import java.util.Scanner;

import com.demo.ejb.banking.command.CreateAccountCommand;
import com.demo.ejb.banking.command.CreditCommand;
import com.demo.ejb.banking.command.DebitCommand;
import com.demo.ejb.banking.command.QueryBalanceCommand;
import com.demo.ejb.banking.command.TransferCommand;

import picocli.CommandLine;
import picocli.CommandLine.HelpCommand;

public class BankingDemo {

	public static void main(String[] args) {
		String line = null;
		try(final Scanner scanner = new Scanner(System.in)){
			scanner.useDelimiter(System.lineSeparator());
			System.out.print("> ");
			while(!"exit".equalsIgnoreCase(line = scanner.next())) {
				final Object command = resolveCommand(line);
				final CommandLine commandLine = new CommandLine(command);
				commandLine.execute(resolveArgs(line));
				final String result = commandLine.getExecutionResult();
				System.out.println(result);
				System.out.print("> ");
			}
		}
	}
	
	private static String[] resolveArgs(String line) {
		final String[] tokens = line.split("[\\s]+");
		final String[] args = new String[tokens.length - 1];
		System.arraycopy(tokens, 1, args, 0, tokens.length - 1);
		return args;
	}
	
	private static Object resolveCommand(String line) {
		if(line.trim().toLowerCase().startsWith("create-account")) {
			return new CreateAccountCommand();
		} else if(line.trim().toLowerCase().startsWith("query-balance")) {
			return new QueryBalanceCommand();
		} else if(line.trim().toLowerCase().startsWith("credit")) {
			return new CreditCommand();
		} else if(line.trim().toLowerCase().startsWith("debit")) {
			return new DebitCommand();
		} else if(line.trim().toLowerCase().startsWith("transfer")) {
			return new TransferCommand();
		} else {
			return new HelpCommand();
		}
	}
	
}
