package com.pizzastore.pizza.frenchfries;

import java.util.EnumMap;
import java.util.Map;

import com.pizzastore.exceptions.OutOfStockException;
import com.pizzastore.orders.FoodItem;
import com.pizzastore.orders.FoodItemName;
import com.pizzastore.store.Storage;

public class FrenchFries implements FoodItem {

	private boolean isAvailable;
	private Size size;

	private static final Map<Size, Double> prices;

	static {

		prices = new EnumMap<>(Size.class);

		prices.put(Size.SMALL, 75d);
		prices.put(Size.MEDIUM, 100d);
		prices.put(Size.LARGE, 120d);
	}

	public FrenchFries() {
		isAvailable = true;
		size = Size.SMALL;
	}

	public FrenchFries(Size size) {
		this();
		this.size = size;
	}

	@Override
	public String getName() {
		return "French Fries";
	}

	@Override
	public double getPrice() {
		return prices.get(this.size);
	}

	@Override
	public void bake() throws OutOfStockException {
		
		Storage.get(FoodItemName.FRENCH_FRIES);
		
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
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
