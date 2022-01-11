package com.pizzastore.store;

import java.util.EnumMap;
import java.util.Map;

import com.pizzastore.exceptions.OutOfStockException;
import com.pizzastore.orders.FoodItem;
import com.pizzastore.orders.FoodItemName;

public final class Storage {

	private static final Map<FoodItemName, Integer> STORE;

	static {

		STORE = new EnumMap<>(FoodItemName.class);

		STORE.put(FoodItemName.COFFEE, 10);
		STORE.put(FoodItemName.FRENCH_FRIES, 10);
		STORE.put(FoodItemName.PIZZA, 10);
	}

	private Storage() {

	}

	public static FoodItem get(FoodItemName itemName) throws OutOfStockException {

		Integer availableCount = STORE.get(itemName);
		if (availableCount == null || availableCount <= 0) {
			throw new OutOfStockException("Not in stock.");
		}

		STORE.put(itemName, --availableCount);
		displayAvailability();
		return null;
	}
	
	public static void returnItem(FoodItemName itemName) {
		
		Integer availableCount = STORE.get(itemName);
		STORE.put(itemName, ++availableCount);
	}

	private static void displayAvailability() {
		System.out.println(STORE);
	}

}