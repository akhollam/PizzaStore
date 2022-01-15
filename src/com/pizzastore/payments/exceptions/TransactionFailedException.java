package com.pizzastore.payments.exceptions;

public class TransactionFailedException extends PaymentFailedException {

	private static final long serialVersionUID = 1L;

	public TransactionFailedException(String msg) {
		super(msg);
	}

}
