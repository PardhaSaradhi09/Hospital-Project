package org.hospital.controllerAdvice;

public class ErrorDetails  {

	private String error;
	private String statusCode;
	private String message;
	private String path;

	public ErrorDetails(String error, String statusCode, String message,  String path) {
		super();
		this.error = error;
		this.statusCode = statusCode;
		this.message = message;
		this.path = path;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
