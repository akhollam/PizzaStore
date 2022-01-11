package com.pizzastore.exceptions;

public class OutOfStockException extends Exception {

	public OutOfStockException() {
		super();
	}

	public OutOfStockException(String message) {
		super(message);
	}

}
