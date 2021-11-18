package com.axis.exception;

public class IdMisMatchedException extends Exception {
private String message;

public IdMisMatchedException(String message) {
	super();
	this.message = message;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

}
