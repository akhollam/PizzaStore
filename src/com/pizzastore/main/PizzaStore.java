package com.pizzastore.main;

import java.util.LinkedList;
import java.util.List;

import com.pizzastore.coffee.Americano;
import com.pizzastore.coffee.Cappuccino;
import com.pizzastore.coffee.Coffee;
import com.pizzastore.coffee.Latte;
import com.pizzastore.exceptions.OrderAlreadyPlacedException;
import com.pizzastore.exceptions.OrderException;
import com.pizzastore.exceptions.OrderNotFoundException;
import com.pizzastore.exceptions.OutOfStockException;
import com.pizzastore.frenchfries.FrenchFries;
import com.pizzastore.frenchfries.Size;
import com.pizzastore.orders.FoodItem;
import com.pizzastore.orders.FoodItemName;
import com.pizzastore.orders.Order;
import com.pizzastore.pizza.CheeseBurstPizza;
import com.pizzastore.pizza.MargheritaPizza;
import com.pizzastore.pizza.Pizza;
import com.pizzastore.pizza.toppings.Mushrooms;
import com.pizzastore.pizza.toppings.Onions;
import com.pizzastore.store.Storage;

public class PizzaStore {

	private List<Order> orders;

	public PizzaStore() {
		orders = new LinkedList<>();
	}

	public double placeOrder(Order order) throws OrderAlreadyPlacedException {

		int index = orders.indexOf(new Order(order.getOrderId()));
		if (index != -1) {
			throw new OrderAlreadyPlacedException();
		}

		List<FoodItem> foodItems = order.getFoodItem();
		for (FoodItem foodItem : foodItems) {

			try {

				foodItem.bake();

			} catch (OutOfStockException e) {
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

	public static void main(String[] args) {

		for (int i = 0; i < 12; i++) {

			PizzaStore pizzaStore = new PizzaStore();
			Order order = new Order();

			Pizza cheeseBurstPizza = new CheeseBurstPizza();
			cheeseBurstPizza.addExtra(new Onions());
			cheeseBurstPizza.addExtra(new Mushrooms());

			Pizza margheritaPizza = new MargheritaPizza();

			order.addFoodItem(cheeseBurstPizza);
			order.addFoodItem(margheritaPizza);
			order.addFoodItem(new Cappuccino());
			order.addFoodItem(new Americano());
			order.addFoodItem(new Latte());
			order.addFoodItem(new FrenchFries(Size.MEDIUM));

			try {

				pizzaStore.placeOrder(order);
				pizzaStore.displayOrders();
				Order orderToBeModified = pizzaStore.modifyOrder(order.getOrderId());
				// orderToBeModified.addFoodItem(new FrenchFries(Size.LARGE));

			} catch (OrderException e) {
				System.err.println("Order not found. ");
			}

			pizzaStore.displayOrders();

			pizzaStore.cancelOrder(order.getOrderId());

			pizzaStore.displayOrders();

			Storage.displayAvailability();

			System.out.println("\n**********************************************************\n");

		}

	}

}
