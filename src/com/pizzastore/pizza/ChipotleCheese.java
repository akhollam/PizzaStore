package com.pizzastore.pizza;

public class ChipotleCheese implements CheeseType {

	@Override
	public String getType() {
		return "Chipotle Cheese";
	}

	@Override
	public double getPrice() {
		return 80;
	}

}
