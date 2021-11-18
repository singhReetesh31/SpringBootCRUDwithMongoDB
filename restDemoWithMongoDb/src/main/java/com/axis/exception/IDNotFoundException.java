package com.axis.exception;




public class IDNotFoundException extends Exception {
private String message;

public IDNotFoundException(String message) {
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
