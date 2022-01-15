package com.pizzastore.exceptions;

public class FoodItemOutOfStockException extends OrderException {

	private static final long serialVersionUID = 1L;

	public FoodItemOutOfStockException() {
		super();
	}

	public FoodItemOutOfStockException(String message) {
		super(message);
	}

}
