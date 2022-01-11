package com.pizzastore.coffee;

import com.pizzastore.orders.FoodItem;

public abstract class Coffee implements FoodItem {

	private boolean isAvailable;
	protected CoffeeSize coffeeSize;

	public Coffee() {
		isAvailable = true;
		coffeeSize = CoffeeSize.MEDIUM;
	}

	public Coffee(CoffeeSize coffeeSize) {
		this();
		this.coffeeSize = coffeeSize;
	}

	@Override
	public String getName() {
		return "Coffee";
	}

	public CoffeeSize getCoffeeSize() {
		return coffeeSize;
	}

	public void setCoffeeSize(CoffeeSize coffeeSize) {
		this.coffeeSize = coffeeSize;
	}

	@Override
	public boolean getIsAvailable() {
		return isAvailable;
	}

	@Override
	public void setAvailable(boolean avaibility) {
		this.isAvailable = avaibility;
	}

}
