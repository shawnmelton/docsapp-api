package com.docs.app.beans;

public class AuthRequest {
	private String password;
	private String screenName;
	
	public AuthRequest() {
		this.password = "";
		this.screenName = "";
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getScreenName() {
		return screenName;
	}
	
	public void setPassword(final String password) {
		this.password = password;
	}
	
	public void setScreenName(final String screenName) {
		this.screenName = screenName;
	}
}
