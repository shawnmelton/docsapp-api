package com.docs.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docs.app.beans.User;
import com.docs.app.repos.UsersRepo;

@Service
public class UsersService {
	
	@Autowired
	private UsersRepo repository;
	
	/**
	 * Create a new user.  Make sure it does not already exist before creating it.
	 * @param <User> user
	 * @return <Integer>
	 */
	public int create(final User user) {
		if (this.findByScreenName(user.getScreenName()) == null) {
			return this.repository.create(user);
		}
		
		return 0;
	}
	
	public User findById(final int id) {
		return this.repository.read(id);
	}
	
	public User findByScreenName(final String screenName) {
		return this.repository.read(screenName);
	}
}
