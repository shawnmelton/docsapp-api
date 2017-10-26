package com.docs.app.services.validators;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class EmailValidator {
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	public boolean isValid(final String email) {
		final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		return pattern.matcher(email)
			.matches();
	}
}
