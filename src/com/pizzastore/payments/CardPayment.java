package com.pizzastore.payments;

import com.pizzastore.payments.exceptions.PaymentFailedException;
import com.pizzastore.payments.exceptions.TransactionFailedException;

public class CardPayment implements Payment {

	private String cardNumer;
	private String cardType;

	public CardPayment(String cardNumer) {
		this.cardNumer = cardNumer;
	}

	@Override
	public long pay(double amount) throws PaymentFailedException {

		// someting went wrong
		throw new TransactionFailedException("Invalid pin");
	}

	public String getCardNumer() {
		return cardNumer;
	}

	public void setCardNumer(String cardNumer) {
		this.cardNumer = cardNumer;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

}