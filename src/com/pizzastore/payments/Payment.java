package com.pizzastore.payments;

import com.pizzastore.payments.exceptions.PaymentFailedException;

public interface Payment {
	
	long pay(double amount) throws PaymentFailedException;

}
