package com.demo.ejb;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Remote
@Stateless
public class RemoteGreetingService implements GreetingService {

	public String greet(String name) {
		return "Hello " + name;
	}

}
