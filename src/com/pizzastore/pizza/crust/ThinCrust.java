package com.pizzastore.pizza.crust;

public class ThinCrust implements PizzaCrusts {

	@Override
	public String getName() {
		return "Thin Crust";
	}

	@Override
	public double getPrice() {
		return 75;
	}

}
