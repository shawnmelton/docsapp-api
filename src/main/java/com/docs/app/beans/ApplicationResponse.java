package com.docs.app.beans;

public class ApplicationResponse<T> {
	private ApplicationResponseStatus status;
	private ApplicationResponseResult<T> result;
	
	public enum ApplicationResponseType {
		OK, BAD_REQUEST, FORBIDDEN, NOT_FOUND, SERVER_ERROR, UNKNOWN_ERROR
	}
	
	public ApplicationResponseResult<T> getResult() {
		return this.result;
	}
	
	public ApplicationResponseStatus getStatus() {
		return this.status;
	}
	
	public void setResult(final T result) {
		this.result = new ApplicationResponseResult<T>(result);
	}
	
	public void setType(final ApplicationResponseType type) {
		switch (type) {
			case OK:
				this.status = new ApplicationResponseStatus(200, "OK");
				break;
				
			case BAD_REQUEST:
				this.status = new ApplicationResponseStatus(400, "Bad Request");
				break;
				
			case NOT_FOUND:
				this.status = new ApplicationResponseStatus(404, "Not Found");
				break;
				
			case SERVER_ERROR:
				this.status = new ApplicationResponseStatus(500, "Server Error");
				break;
				
			case UNKNOWN_ERROR:
			default:
				this.status = new ApplicationResponseStatus(520, "Unknown Error");
				break;
		}
		
	}
	
	
	/**
	 * Define inner classes that will only be utilized by this class.
	 * @author shawn.melton
	 *
	 */
	
	private class ApplicationResponseStatus {
		private int code;
		private String message;
		
		public ApplicationResponseStatus(final int code, final String message) {
			this.code = code;
			this.message = message;
		}
		
		public int getCode() {
			return this.code;
		}
		
		public String getMessage() {
			return this.message;
		}
	}

	private class ApplicationResponseResult<T> {
		private T result;
		
		public ApplicationResponseResult(final T result) {
			this.result = result;
		}
		
		public T getResult() {
			return this.result;
		}
	}
}

