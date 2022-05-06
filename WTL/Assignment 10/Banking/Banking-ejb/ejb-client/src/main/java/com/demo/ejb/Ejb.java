package com.demo.ejb;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

public final class Ejb {

	private Ejb() {}
	
	@SuppressWarnings("unchecked")
	public static <T> T lookup(String name, Class<T> type) throws NamingException {
		final Properties properties = new Properties();
		properties.put(Context.INITIAL_CONTEXT_FACTORY,"org.apache.openejb.client.RemoteInitialContextFactory"); 
		properties.put(Context.PROVIDER_URL,"http://localhost:8080/tomee/ejb"); 
		final Context context = new InitialContext(properties); 
		final Object reference = context.lookup(name); 
		return (T) PortableRemoteObject.narrow(reference, type); 
	}
	
}
