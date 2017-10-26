package com.docs.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.docs.app.beans.ApplicationResponse;
import com.docs.app.beans.ApplicationResponse.ApplicationResponseType;
import com.docs.app.beans.User;
import com.docs.app.services.UsersService;
import com.docs.app.services.validators.UserSubmissionValidator;

@RestController
@RequestMapping("/users")
public class Users extends BaseController {
	
	@Autowired
	private UsersService service;
	
	@Autowired
	private UserSubmissionValidator userValidator;
	
	@RequestMapping(method = RequestMethod.POST)
	public ApplicationResponse<String> create(@RequestParam(required=true) final String firstName,
		@RequestParam(required=true) final String lastName, @RequestParam(required=true) final String emailAddress,
		@RequestParam(required=true) final String screenName) {
		final User body = new User();
		body.setFirstName(firstName);
		body.setLastName(lastName);
		body.setEmailAddress(emailAddress);
		body.setScreenName(screenName);
			
		if (this.userValidator.isValid(body)) {
			final int userId = this.service.create(body);
			if (userId > 0) {
				return this.getStringResponse(ApplicationResponseType.OK, Integer.toString(userId));
			}
				
			return this.getStringResponse(ApplicationResponseType.SERVER_ERROR, "Failed creating user account.");
		}
		
		return this.getStringResponse(ApplicationResponseType.BAD_REQUEST, "Invalid submission.");
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ApplicationResponse<User> getById(@PathVariable final int id) {
		final User user = this.service.findById(id);
		ApplicationResponseType responseType = ApplicationResponseType.NOT_FOUND;
		if (user != null) {
			responseType = ApplicationResponseType.OK;
		}
		
		final ApplicationResponse<User> response = new ApplicationResponse<User>();
		response.setResult(user);
		response.setType(responseType);
		return response;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/find/{screenName}")
	public ApplicationResponse<User> getByScreenName(@PathVariable final String screenName) {
		final User user = this.service.findByScreenName(screenName);
		ApplicationResponseType responseType = ApplicationResponseType.NOT_FOUND;
		if (user != null) {
			responseType = ApplicationResponseType.OK;
		}
		
		final ApplicationResponse<User> response = new ApplicationResponse<User>();
		response.setResult(user);
		response.setType(responseType);
		return response;
	}
}
