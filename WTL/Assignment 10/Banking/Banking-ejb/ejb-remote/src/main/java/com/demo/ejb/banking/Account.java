package com.demo.ejb.banking;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class Account {

	private final String name;
	private final AtomicReference<BigDecimal> balance;
	
	public Account(final String name) {
		this(name, BigDecimal.ZERO);
	}
	
	public Account(final String name, BigDecimal balance) {
		Objects.requireNonNull(name);
		Objects.requireNonNull(balance);
		this.name = name;
		this.balance = new AtomicReference<>(balance);
	}
	
	public String getName() {
		return name;
	}
	
	public BigDecimal getBalance() {
		return balance.get();
	}
	
	public Account credit(BigDecimal amount) {
		Objects.requireNonNull(amount);
		this.balance.set(this.balance.get().add(amount));
		return this;
	}
	
	public Account debit(BigDecimal amount) {
		Objects.requireNonNull(amount);
		this.balance.set(this.balance.get().subtract(amount));
		return this;
	}
}
