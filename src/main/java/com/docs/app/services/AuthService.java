package com.docs.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docs.app.beans.User;
import com.docs.app.repos.UsersRepo;

@Service
public class AuthService {
	@Autowired
	private UsersRepo repository;
	
	public boolean findByCredentials(final String screenName, final String password) {
		final User user = this.repository.read(screenName);
		return (user != null && user.getPassword().equals(password));
	}
}
