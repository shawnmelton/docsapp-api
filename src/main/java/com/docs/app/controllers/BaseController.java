package com.docs.app.controllers;

import com.docs.app.beans.ApplicationResponse;
import com.docs.app.beans.ApplicationResponse.ApplicationResponseType;

public class BaseController {
	public ApplicationResponse<String> getStringResponse(final ApplicationResponseType type, final String result) {
		final ApplicationResponse<String> response = new ApplicationResponse<String>();
		response.setResult(result);
		response.setType(type);
		return response;
	}
}
