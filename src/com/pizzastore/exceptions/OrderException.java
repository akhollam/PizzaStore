package com.pizzastore.exceptions;

public class OrderException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public OrderException() {
		super();
	}

	public OrderException(String message) {
		super(message);
	}

}
