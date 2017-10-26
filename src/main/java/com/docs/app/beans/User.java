package com.docs.app.beans;

import java.util.Date;

public class User {
	private Date dateAdded;
	private Date dateUpdated;
	private String emailAddress;
	private String firstName;
	private int id;
	private String lastName;
	private String screenName;
	
	public Date getDateAdded() {
		return dateAdded;
	}
	
	public Date getDateUpdated() {
		return dateUpdated;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public int getId() {
		return id;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getScreenName() {
		return screenName;
	}
	
	public void setDateAdded(final Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
	
	public void setDateUpdated(final Date dateAdded) {
		this.dateAdded = dateAdded;
	}
	
	public void setEmailAddress(final String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}
	
	public void setId(final int id) {
		this.id = id;
	}
	
	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}
	
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
}