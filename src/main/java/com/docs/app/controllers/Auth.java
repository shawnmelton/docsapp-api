package com.docs.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.docs.app.beans.ApplicationResponse;
import com.docs.app.beans.ApplicationResponse.ApplicationResponseType;
import com.docs.app.beans.AuthRequest;
import com.docs.app.services.AuthService;
import com.docs.app.services.JSONParser;

@CrossOrigin(origins = "http://dev.docsapp.com")
@RestController
@RequestMapping("/auth")
public class Auth extends BaseController {
	@Autowired
	private AuthService service;
	
	@RequestMapping(method = RequestMethod.POST)
	public ApplicationResponse<Boolean> validate(
		@RequestBody(required=true) final String json) {
		final JSONParser<AuthRequest> parser = new JSONParser<AuthRequest>();
		final AuthRequest request = parser.parseString(json, AuthRequest.class);
		ApplicationResponseType responseType = ApplicationResponseType.OK;
		
		if (request.getScreenName().length() < 3 || request.getPassword().length() < 3) {
			responseType = ApplicationResponseType.BAD_REQUEST;
		}
		
		return this.getBooleanResponse(responseType, this.service.findByCredentials(request.getScreenName(), request.getPassword()));
	}
}
