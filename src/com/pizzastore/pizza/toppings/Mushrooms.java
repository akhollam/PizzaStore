package com.pizzastore.pizza.toppings;

public class Mushrooms implements Toppings {

	@Override
	public String getName() {
		return "Mushrooms";
	}

	@Override
	public double getPrice() {
		return 75;
	}

}
