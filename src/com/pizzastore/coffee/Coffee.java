package com.pizzastore.coffee;

import com.pizzastore.orders.FoodItem;

public class Coffee implements FoodItem {

	@Override
	public String getName() {
		return "Coffee";
	}

	@Override
	public double getPrice() {
		return 30;
	}
	
	@Override
	public void bake() {
		
	}

}
