package edu.example.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.example.shared.GetSet;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
	/*String check(String s1,String s2) throws IllegalArgumentException;
	String register(String s1,String s2,String s3)throws IllegalArgumentException;*/
	
	GetSet check(GetSet g) throws IllegalArgumentException;
	GetSet register(GetSet g)throws IllegalArgumentException;
	GetSet update(GetSet g)throws IllegalArgumentException;
	GetSet extract(GetSet g)throws IllegalArgumentException;
	
}
