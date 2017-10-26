package com.docs.app.beans;

import java.util.Date;

public class Category {
	private Date dateAdded;
	private Date dateUpdated;
	private int id;
	private String name;
	
	public Date getDateAdded() {
		return dateAdded;
	}
	
	public Date getDateUpdated() {
		return dateUpdated;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setDateAdded(final Date dateAdded) {
		this.dateAdded = dateAdded;
	}
	
	public void setDateUpdated(final Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
	
	public void setId(final int id) {
		this.id = id;
	}
	
	public void setName(final String name) {
		this.name = name;
	}
}
