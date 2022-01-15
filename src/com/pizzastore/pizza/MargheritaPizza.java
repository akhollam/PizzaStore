package com.pizzastore.pizza;

import com.pizzastore.exceptions.FoodItemOutOfStockException;
import com.pizzastore.orders.FoodItemName;
import com.pizzastore.pizza.toppings.Mushrooms;
import com.pizzastore.store.Storage;

public class MargheritaPizza extends Pizza {

	public MargheritaPizza() {
		super("Margherita Pizza");
	}

	@Override
	public double getBasePrice() {
		return 800;
	}

	@Override
	public void bake() throws FoodItemOutOfStockException {
		
		Storage.get(FoodItemName.PIZZA);
		this.addToppings(new Mushrooms());
	}
	
}
