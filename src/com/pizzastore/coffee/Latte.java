package com.pizzastore.coffee;

import com.pizzastore.exceptions.OutOfStockException;
import com.pizzastore.orders.FoodItemName;
import com.pizzastore.store.Storage;

/**
 * This is an espresso with steamed milk, usually with a shallow pool of foam
 * floating on top.
 * 
 */
public class Latte extends Coffee {

	@Override
	public double getPrice() {
		return 65;
	}

	@Override
	public void bake() throws OutOfStockException {
		Storage.get(FoodItemName.COFFEE);
	}

	@Override
	public String getName() {
		return "Latte Coffee";
	}

}
