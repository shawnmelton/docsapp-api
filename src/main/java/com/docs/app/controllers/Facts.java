package com.docs.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.docs.app.beans.ApplicationResponse;
import com.docs.app.beans.ApplicationResponse.ApplicationResponseType;
import com.docs.app.beans.Fact;
import com.docs.app.services.FactsService;

@RestController
@RequestMapping("/articles")
public class Facts extends BaseController {
	@Autowired
	private FactsService service;
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ApplicationResponse<Fact> getById(@PathVariable final int id) {
		final Fact fact = this.service.findById(id);
		ApplicationResponseType responseType = ApplicationResponseType.NOT_FOUND;
		if (fact != null) {
			responseType = ApplicationResponseType.OK;
		}
		
		final ApplicationResponse<Fact> response = new ApplicationResponse<Fact>();
		response.setResult(fact);
		response.setType(responseType);
		return response;
	}
}
