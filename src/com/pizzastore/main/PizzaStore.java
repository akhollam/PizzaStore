package com.pizzastore.main;

import java.util.LinkedList;
import java.util.List;

import com.pizzastore.coffee.Coffee;
import com.pizzastore.exceptions.FoodItemOutOfStockException;
import com.pizzastore.exceptions.OrderAlreadyPlacedException;
import com.pizzastore.exceptions.OrderNotFoundException;
import com.pizzastore.frenchfries.FrenchFries;
import com.pizzastore.orders.FoodItem;
import com.pizzastore.orders.FoodItemName;
import com.pizzastore.orders.Order;
import com.pizzastore.payments.Payment;
import com.pizzastore.payments.exceptions.PaymentFailedException;
import com.pizzastore.pizza.Pizza;
import com.pizzastore.store.Storage;

public class PizzaStore {

	private List<Order> orders;

	public PizzaStore() {
		orders = new LinkedList<>();
	}

	public void placeOrder(Order order, Payment payment) throws PaymentFailedException, OrderAlreadyPlacedException {
		long transactionId = payment.pay(order.getFinalPrice());
		placeOrder(order);
	}

	private double placeOrder(Order order) throws OrderAlreadyPlacedException {

		int index = orders.indexOf(new Order(order.getOrderId()));
		if (index != -1) {
			throw new OrderAlreadyPlacedException();
		}

		List<FoodItem> foodItems = order.getFoodItem();
		for (FoodItem foodItem : foodItems) {

			try {

				foodItem.bake();

			} catch (FoodItemOutOfStockException e) {
				foodItem.setAvailable(false);
				System.err.println(foodItem.getName() + " is out of stock.");
			}
		}

		orders.add(order);
		order.displayOrder();
		return order.getFinalPrice();
	}

	public Order modifyOrder(long orderId) throws OrderNotFoundException {

		int index = orders.indexOf(new Order(orderId));
		if (index != -1) {
			return orders.get(index);
		}

		throw new OrderNotFoundException();
	}

	public void cancelOrder(long orderId) {

		int index = orders.indexOf(new Order(orderId));
		if (index != -1) {
			Order removedOrder = orders.remove(index);
			for (FoodItem order : removedOrder.getFoodItem()) {
				if (order instanceof Pizza) {
					Storage.returnItem(FoodItemName.PIZZA);
				} else if (order instanceof Coffee) {
					Storage.returnItem(FoodItemName.COFFEE);
				} else if (order instanceof FrenchFries) {
					Storage.returnItem(FoodItemName.FRENCH_FRIES);
				}
			}
		}

	}

	public void displayOrders() {
		System.out.println("There are : " + orders.size() + " Orders");
		for (Order order : orders) {
			System.out.println(order);
		}
	}

}
