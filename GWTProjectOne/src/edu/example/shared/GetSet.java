package edu.example.shared;

import java.io.Serializable;
import java.util.ArrayList;

public class GetSet implements Serializable{
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	String username;
	String pwd;
    String email;
    public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	String msg;
	String update;
	public String getUpdate() {
		return update;
	}
	public void setUpdate(String update) {
		this.update = update;
	}
	
	String question;
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	ArrayList<String> al;
	public ArrayList<String> getAl() {
		return al;
	}
	public void setAl(ArrayList<String> al) {
		this.al = al;
	}
	
	
}
