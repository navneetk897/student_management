package com.navneet.mybattis;

public class GetUser {
	
	private String userName;
	private String password;
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public GetUser(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	
	public GetUser() {
		
	}
}
