package edu.example.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import edu.example.shared.GetSet;

public class jojo2 extends Composite  {

	private static jojo2UiBinder uiBinder = GWT.create(jojo2UiBinder.class);

	interface jojo2UiBinder extends UiBinder<Widget, jojo2> {
	}

	@UiField(provided = true)
	   final LoginResources res;

@UiField
Button button;


@UiField
TextBox email;
@UiField
TextBox username;
@UiField
PasswordTextBox pwd;
@UiField
HTMLPanel html;

@UiField
Label completionLabel1;

@UiField
Label completionLabel2;
@UiField
Image img;

@UiField
Button login;
@UiField

Button update;



GreetingServiceAsync  a1=GWT.create(GreetingService.class);


public jojo2() {
	
	 this.res = GWT.create(LoginResources.class);
  res.style().ensureInjected();
   	initWidget(uiBinder.createAndBindUi(this));
img.setUrl("images/ransack.png");

}
private Boolean tooShort = false;

@UiHandler("button")
void onClick(ClickEvent e) {
	//Window.alert("Hello!");
	
	String s1=jojo2.this.email.getText();
	String s2= jojo2.this.username.getText();
	String s3=jojo2.this.pwd.getText();
	
	GetSet aa= new GetSet();
	aa.setEmail(s1);
	aa.setUsername(s2);
	aa.setPwd(s3);
	

	a1.register(aa, new AsyncCallback<GetSet>() {
		
		@Override
		public void onSuccess(GetSet result) {
			// TODO Auto-generated method stub
		Window.alert(result.getMsg())	;
		}
		
		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			
		}
	});
	
}

@UiHandler("username")
void handleLoginChange(ValueChangeEvent<String> event) {
if (event.getValue().length() < 3) {
   completionLabel1.setText("Login too short (Size must be > 3)");
   tooShort = true;
} else {
   tooShort = false;
   completionLabel1.setText("");
}
}

@UiHandler("pwd")
void handlePasswordChange(ValueChangeEvent<String> event) {
if (event.getValue().length() < 3) {
   tooShort = true;
   completionLabel2.setText("Password too short (Size must be > 3)");
} else {
   tooShort = false;
   completionLabel2.setText("");
}
}

@UiHandler("login")
void onClick1(ClickEvent e1)
{
	RootPanel.get().clear();
	RootPanel.get().add(new jojo());
	}


@UiHandler("update")
void onClick2(ClickEvent e2)
{
	RootPanel.get().clear();
	RootPanel.get().add(new jojo3());
	}
}
