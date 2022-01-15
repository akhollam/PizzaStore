package com.pizzastore.coffee;

import com.pizzastore.exceptions.FoodItemOutOfStockException;
import com.pizzastore.orders.FoodItemName;
import com.pizzastore.store.Storage;

/**
 * This is just a shot of espresso with hot water.
 *
 */
public class Americano extends Coffee {
	
	public static final String NAME = "Americano Coffee";

	@Override
	public double getPrice() {
		return 120;
	}

	@Override
	public void bake() throws FoodItemOutOfStockException {
		Storage.get(FoodItemName.COFFEE);
	}

	@Override
	public String getName() {
		return NAME;
	}

}
