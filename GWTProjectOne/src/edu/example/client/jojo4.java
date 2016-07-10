package edu.example.client;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import edu.example.shared.GetSet;

public class jojo4 extends Composite  {

	private static jojo4UiBinder uiBinder = GWT.create(jojo4UiBinder.class);

	interface jojo4UiBinder extends UiBinder<Widget, jojo4> {
	}

	public jojo4() {
		initWidget(uiBinder.createAndBindUi(this));
		
		//PushButton pushButton = new PushButton(new Image("images/ransack.png"));
	}

	
	GreetingServiceAsync  a1=GWT.create(GreetingService.class);
	
	@UiField HTMLPanel html;
	@UiField
	Button button1;
	
	@UiField
	Button update;
	
	@UiField
	TextBox searchbox;
	
	@UiHandler("button1")
	void onClick(ClickEvent e)
	{
		String s1=jojo4.this.searchbox.getText();
		
		GetSet aa= new GetSet();
		
		aa.setQuestion(s1);
		
		a1.extract(aa, new AsyncCallback<GetSet>() {
			
			@Override
			public void onSuccess(GetSet result) {
				// TODO Auto-generated method stub
	ArrayList<String> al=result.getAl();
	
	int count=0;
	for(String o: al)
	{ count++;
		//Window.alert(o);
		html.getElementById("content"+count).setInnerHTML(o);
	}
	
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
	}
	
	@UiHandler("update")
	void onClick2(ClickEvent e3)
	{
		RootPanel.get().clear();
		RootPanel.get().add(new jojo3());
	}
	
	
	
	
}
