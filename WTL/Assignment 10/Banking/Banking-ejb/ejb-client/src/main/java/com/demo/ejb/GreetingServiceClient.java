package com.demo.ejb;

import java.util.Scanner;

import javax.naming.NamingException;

public class GreetingServiceClient {
	
	public static void main(String[] args) throws NamingException {
		final GreetingService greetingService = Ejb.lookup("global/ejb-remote-0.0.1-SNAPSHOT/RemoteGreetingService!com.demo.ejb.GreetingService", GreetingService.class); 
		try(final Scanner scanner = new Scanner(System.in)){
			System.out.print("What is your name ?\t");
			final String name = scanner.next();
			final String response = greetingService.greet(name);
			System.out.println(response);
		}
	}
}
