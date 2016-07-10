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

public class jojo3 extends Composite  {

	private static jojo3UiBinder uiBinder = GWT.create(jojo3UiBinder.class);

	interface jojo3UiBinder extends UiBinder<Widget, jojo3> {
	}
	public jojo3() {
		 this.res = GWT.create(LoginResources.class);
	res.style().ensureInjected();
		initWidget(uiBinder.createAndBindUi(this));
	img.setUrl("images/ransack.png");


	}
	
	@UiField(provided = true)
	   final LoginResources res;



@UiField
TextBox email;
@UiField
TextBox username;

@UiField 
TextBox newusername;

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



private Boolean tooShort = false;



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
	String s1=jojo3.this.email.getText();
	String s2= jojo3.this.username.getText();
	String s3=jojo3.this.pwd.getText();
	String s4=jojo3.this.newusername.getText();
	
	GetSet aa= new GetSet();
	aa.setEmail(s1);
	aa.setUsername(s2);
	aa.setPwd(s3);
	aa.setUpdate(s4);
	
	//username.setText(s2);
	a1.update(aa, new AsyncCallback<GetSet>() {
		
		@Override
		public void onSuccess(GetSet result) {
			// TODO Auto-generated method stub
			
			Window.alert(result.getMsg());
		}
		
		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			
		}
	});
	
	}
	@UiField
	Button button1;
	@UiField
	TextBox search;

	/*public jojo3(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		
	}
*/
	@UiHandler("button1")
	void onClick(ClickEvent e) {
		
		kalu1();
		
	}
public native void kalu1()
/*-{
	$wnd.window.location.assign("https://www.google.co.in");
	
	
	}-*/;



}
