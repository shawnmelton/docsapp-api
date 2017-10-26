package com.docs.app.beans;

import java.util.Date;

public class ArticleRevision {
	private Article article;
	private Date dateAdded;
	private int id;
	private User author;
	
	public Article getArticle() {
		return article;
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
	
	public void setArticle(final Article article) {
		this.article = article;
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
