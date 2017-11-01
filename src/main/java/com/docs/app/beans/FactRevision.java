package com.docs.app.beans;

import java.util.Date;

public class FactRevision {
	private Fact fact;
	private Date dateAdded;
	private int id;
	private User author;
	
	public Fact getfact() {
		return fact;
	}
	
	public User getAuthor() {
		return author;
	}
	
	public Date getDateAdded() {
		return dateAdded;
	}
	
	public int getId() {
		return id;
	}
	
	public void setfact(final Fact fact) {
		this.fact = fact;
	}
	
	public void setAuthor(final User author) {
		this.author = author;
	}
	
	public void setDateAdded(final Date dateAdded) {
		this.dateAdded = dateAdded;
	}
	
	public void setId(final int id) {
		this.id = id;
	}
}
