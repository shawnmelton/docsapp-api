package com.docs.app.controllers;

import com.docs.app.beans.ApplicationResponse;
import com.docs.app.beans.ApplicationResponse.ApplicationResponseType;

public class BaseController {
	public ApplicationResponse<Boolean> getBooleanResponse(final ApplicationResponseType type, final Boolean result) {
		final ApplicationResponse<Boolean> response = new ApplicationResponse<Boolean>();
		response.setResult(result);
		response.setType(type);
		return response;
	}
	
	public ApplicationResponse<String> getStringResponse(final ApplicationResponseType type, final String result) {
		final ApplicationResponse<String> response = new ApplicationResponse<String>();
		response.setResult(result);
		response.setType(type);
		return response;
	}
}
