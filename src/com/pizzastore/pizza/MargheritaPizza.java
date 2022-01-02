package com.pizzastore.pizza;

import com.pizzastore.pizza.toppings.Mushrooms;

public class MargheritaPizza extends Pizza {

	public MargheritaPizza() {
		super("Margherita Pizza");
	}

	@Override
	public double getBasePrice() {
		return 800;
	}

	@Override
	public void bake() {
		this.addToppings(new Mushrooms());
	}
	
}
