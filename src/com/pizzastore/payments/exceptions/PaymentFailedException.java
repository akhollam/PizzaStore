package com.pizzastore.payments.exceptions;

public class PaymentFailedException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public PaymentFailedException() {
	}

	public PaymentFailedException(String message) {
		super(message);
	}

}
