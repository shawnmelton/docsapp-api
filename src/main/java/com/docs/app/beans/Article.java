package com.docs.app.beans;

import java.util.ArrayList;
import java.util.Date;

public class Article {
	private ArrayList<Category> categories;
	private String content;
	private Date dateAdded;
	private Date dateUpdated;
	private int id;
	private ArrayList<ArticleRevision> revisions;
	private String title;
	
	public ArrayList<Category> getCategories() {
		return categories;
	}
	
	public String getContent() {
		return content;
	}
	
	public Date getDateAdded() {
		return dateAdded;
	}
	
	public Date getDateUpdated() {
		return dateUpdated;
	}
	
	public int getId() {
		return id;
	}
	
	public ArrayList<ArticleRevision> getRevisions() {
		return revisions;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setCategories(ArrayList<Category> categories) {
		this.categories = categories;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
	
	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setRevisions(ArrayList<ArticleRevision> revisions) {
		this.revisions = revisions;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
}
