package com.pizzastore.pizza;

import com.pizzastore.exceptions.FoodItemOutOfStockException;
import com.pizzastore.orders.FoodItemName;
import com.pizzastore.store.Storage;

public class BasicPizza extends Pizza {

	@Override
	public double getBasePrice() {
		return 500;
	}

	@Override
	public void bake() throws FoodItemOutOfStockException {
		Storage.get(FoodItemName.PIZZA);
	}

}
