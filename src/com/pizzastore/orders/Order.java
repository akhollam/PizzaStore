package com.pizzastore.orders;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Order {

	private long orderId;
	private List<FoodItem> foodItems;
	private LocalDateTime dateTime;
	
	public Order(long orderId) {
		this();
		this.orderId = orderId;
	}

	public Order() {
		this.orderId = new Random().nextInt(300);
		this.foodItems = new LinkedList<>();
		dateTime = LocalDateTime.now();
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

	public void displayOrder() {

		System.out.println("-----------------------------------");
		System.out.println(String.format("| Order No - %s, %17s |", orderId, DateTimeFormatter.ofPattern("hh:mm").format(this.dateTime)));
		System.out.println("-----------------------------------");
		System.out.println(String.format("| %20s | %8s |", "Food Item", "Price"));
		System.out.println("-----------------------------------");
		for (FoodItem foodItem : foodItems) {

			double price = 0d;
			if (foodItem.getIsAvailable()) {
				price = foodItem.getPrice();
			}
			System.out.println(String.format("| %20s | %8.2f |", foodItem.getName(), price));
		}
		System.out.println(String.format("| %20s | %8s |", "", ""));
		System.out.println(String.format("| %20s | %8s |", "", ""));
		System.out.println("-----------------------------------");
		System.out.println(String.format("| %20s | %8.2f |", "Total", getFinalPrice()));
		System.out.println("-----------------------------------");

	}

	public List<FoodItem> getFoodItems() {
		return foodItems;
	}

	public void setFoodItems(List<FoodItem> foodItems) {
		this.foodItems = foodItems;
	}

	public double getFinalPrice() {

		double price = 0;
		for (FoodItem foodItem : foodItems) {
			if (foodItem.getIsAvailable()) {
				price += foodItem.getPrice();
			}
		}
		return price;
	}
	
	@Override
	public String toString() {
		return "Order [Order Number : " + orderId + ", Total Items : " + foodItems.size() + ", placed at time : " + dateTime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (orderId ^ (orderId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (orderId != other.orderId)
			return false;
		return true;
	}

}
