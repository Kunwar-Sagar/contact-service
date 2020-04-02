package com.abc.exceptions;

public class EntityNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private final static String message = "Entity not Found";
			
	public EntityNotFoundException() {
		super(message);
	}
}
