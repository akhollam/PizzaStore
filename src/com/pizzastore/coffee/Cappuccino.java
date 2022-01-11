package com.pizzastore.coffee;

import com.pizzastore.exceptions.OutOfStockException;
import com.pizzastore.orders.FoodItemName;
import com.pizzastore.store.Storage;

/**
 * This is an espresso with a thick layer of foamy steamed milk.
 */
public class Cappuccino extends Coffee {

	@Override
	public double getPrice() {

		double price = 0;

		switch (this.coffeeSize) {

		case SMALL:
			price = 50;
			break;

		case MEDIUM:
			price = 75;
			break;

		case LARGE:
			price = 100;
			break;
		}

		return price;
	}

	@Override
	public String getName() {
		return "Cappuccino Coffee";
	}

	@Override
	public void bake() throws OutOfStockException {
		Storage.get(FoodItemName.COFFEE);
	}

}
