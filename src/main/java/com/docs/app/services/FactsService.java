package com.docs.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docs.app.beans.Fact;
import com.docs.app.repos.FactsRepo;

@Service
public class FactsService {
	@Autowired
	private FactsRepo repository;
	
	public Fact findById(final int id) {
		return this.repository.read(id);
	}
}
