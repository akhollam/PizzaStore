package com.pizzastore.exceptions;

public class OutOfStockException extends OrderException {

	private static final long serialVersionUID = 1L;

	public OutOfStockException() {
		super();
	}

	public OutOfStockException(String message) {
		super(message);
	}

}
