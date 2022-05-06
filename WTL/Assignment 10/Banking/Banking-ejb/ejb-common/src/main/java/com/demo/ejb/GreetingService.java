package com.demo.ejb;

import javax.ejb.Remote;

@Remote
public interface GreetingService {

	String greet(String name);
	
}
