package com.pizzastore.orders;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Order {

	private long orderId;
	private List<FoodItem> foodItems;

	public Order() {
		this.orderId = new Random().nextLong();
		this.foodItems = new ArrayList<FoodItem>();
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public List<FoodItem> getFoodItem() {
		return foodItems;
	}

	public void addFoodItem(FoodItem item) {
		this.foodItems.add(item);
	}

	public void setFoodItem(List<FoodItem> foodItem) {
		this.foodItems = foodItem;
	}

	public double getFinalPrice() {

		double price = 0;
		for (FoodItem foodItem : foodItems) {

			System.out.println(foodItem.getName() + "" + foodItem.getPrice());

			price += foodItem.getPrice();
		}

		return price;
	}

}
