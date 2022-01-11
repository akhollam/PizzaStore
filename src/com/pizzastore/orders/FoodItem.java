package com.pizzastore.orders;

import com.pizzastore.exceptions.OutOfStockException;

public interface FoodItem {

	String getName();

	double getPrice();

	boolean getIsAvailable();

	void setAvailable(boolean avaibility);

	void bake() throws OutOfStockException;

}
