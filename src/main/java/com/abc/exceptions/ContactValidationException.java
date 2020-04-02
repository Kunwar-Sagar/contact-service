package com.abc.exceptions;

public class ContactValidationException  extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ContactValidationException(String message) {
		super(message);
	}
}
