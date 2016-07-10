/*package edu.example.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class look extends Composite{
	final VerticalPanel vpanel=new VerticalPanel();
	final GreetingServiceAsync  a1=GWT.create(GreetingService.class);
	public look()
	{
		initWidget(this.vpanel);
		
	
		
		final Image img =new Image("images/ransack.jpg");
	
		

		final DialogBox d=new DialogBox();
		d.setAnimationEnabled(true);
		
		final DecoratedPopupPanel simplePopup = new DecoratedPopupPanel(true);
		simplePopup.setWidth("150px");
		
		final HorizontalPanel hp = new HorizontalPanel();
		final HorizontalPanel hp1 = new HorizontalPanel();
		vpanel.add(img);
		
		vpanel.setBorderWidth(1);
		
		final TextBox t1=new TextBox();
		final Label mylbl =new Label("Username :");
		
		final TextBox t2=new TextBox();
		final Label mylbl2 =new Label("Password :");
		
		hp.add(mylbl);
		hp.add(t1);
		
		vpanel.add(hp);
		
		hp1.add(mylbl2);
		hp1.add(t2);

		
		vpanel.add(hp1);
		
	    final Button b1=new Button();
	    b1.setText("Submit");
	    
	    vpanel.add(b1);
	    
	    b1.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
			String s1 = t1.getText();
			String s2 = t2.getText();
			

			
			a1.check(s1,s2, new AsyncCallback <String>(){

				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onSuccess(String result) {
					
				Window.alert(result);
			
		
				}
				
			});
			
			}
			
		});	    
			    
		}
	
			
	}


*/