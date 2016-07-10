package edu.example.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.example.shared.GetSet;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {

	void register(GetSet g, AsyncCallback<GetSet> callback);

	void check(GetSet g, AsyncCallback<GetSet> callback);

	void update(GetSet g, AsyncCallback<GetSet> callback);

	void extract(GetSet g, AsyncCallback<GetSet> callback);

	
}
