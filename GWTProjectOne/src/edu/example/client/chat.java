package edu.example.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

public class chat extends Composite  {

	private static chatUiBinder uiBinder = GWT.create(chatUiBinder.class);

	interface chatUiBinder extends UiBinder<Widget, chat> {
	}

	public chat() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	
}
