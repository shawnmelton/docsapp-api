package com.docs.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.docs.app.beans.ApplicationResponse;
import com.docs.app.beans.ApplicationResponse.ApplicationResponseType;
import com.docs.app.beans.Article;
import com.docs.app.services.ArticlesService;

@RestController
@RequestMapping("/articles")
public class Articles extends BaseController {
	@Autowired
	private ArticlesService service;
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ApplicationResponse<Article> getById(@PathVariable final int id) {
		final Article article = this.service.findById(id);
		ApplicationResponseType responseType = ApplicationResponseType.NOT_FOUND;
		if (article != null) {
			responseType = ApplicationResponseType.OK;
		}
		
		final ApplicationResponse<Article> response = new ApplicationResponse<Article>();
		response.setResult(article);
		response.setType(responseType);
		return response;
	}
}
