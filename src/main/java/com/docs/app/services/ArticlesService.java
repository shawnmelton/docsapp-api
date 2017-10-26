package com.docs.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docs.app.beans.Article;
import com.docs.app.repos.ArticlesRepo;

@Service
public class ArticlesService {
	@Autowired
	private ArticlesRepo repository;
	
	public Article findById(final int id) {
		return this.repository.read(id);
	}
}
