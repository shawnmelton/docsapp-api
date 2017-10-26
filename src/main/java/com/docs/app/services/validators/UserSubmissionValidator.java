package com.docs.app.services.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docs.app.beans.User;

@Service
public class UserSubmissionValidator {
	
	@Autowired
	private EmailValidator emailValidator;
	
	public boolean isValid(final User user) {
		return (user.getFirstName().length() > 0 && user.getLastName().length() > 0 &&
			user.getEmailAddress().length() > 0 && user.getScreenName().length() > 0 &&
			this.emailValidator.isValid(user.getEmailAddress()));
	}
}
