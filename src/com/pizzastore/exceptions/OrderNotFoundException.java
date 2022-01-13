package com.pizzastore.exceptions;

public class OrderNotFoundException extends OrderException {

	private static final long serialVersionUID = 1L;

	public OrderNotFoundException() {
		super();
	}

	public OrderNotFoundException(String message) {
		super(message);
	}

}
