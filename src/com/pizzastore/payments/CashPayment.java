package com.pizzastore.payments;

public class CashPayment implements Payment {

	@Override
	public long pay(double amount) {
		return 1L;
	}

}
