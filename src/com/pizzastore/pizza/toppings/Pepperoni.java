package com.pizzastore.pizza.toppings;

public class Pepperoni implements Toppings {

	@Override
	public String getName() {
		return "Pepperoni";
	}

	@Override
	public double getPrice() {
		return 95;
	}

}
