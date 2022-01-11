package com.pizzastore.main;

import java.util.LinkedList;
import java.util.List;

import com.pizzastore.coffee.Americano;
import com.pizzastore.coffee.Cappuccino;
import com.pizzastore.coffee.Latte;
import com.pizzastore.exceptions.OutOfStockException;
import com.pizzastore.orders.FoodItem;
import com.pizzastore.orders.FoodItemName;
import com.pizzastore.orders.Order;
import com.pizzastore.pizza.CheeseBurstPizza;
import com.pizzastore.pizza.MargheritaPizza;
import com.pizzastore.pizza.Pizza;
import com.pizzastore.pizza.frenchfries.FrenchFries;
import com.pizzastore.pizza.frenchfries.Size;
import com.pizzastore.pizza.toppings.Mushrooms;
import com.pizzastore.pizza.toppings.Onions;
import com.pizzastore.store.Storage;

public class PizzaStore {

	private List<Order> orders;

	public PizzaStore() {
		orders = new LinkedList<>();
	}

	public double placeOrder(Order order) {

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

	public void modifyOrder(long orderId) {

		int index = orders.indexOf(new Order(orderId));
		if (index != -1) {
			Order order = orders.get(index);
			// TODO : modify the order
		}
	}

	public void cancelOrder(long orderId) {

		int index = orders.indexOf(new Order(orderId));
		if (index != -1) {
			Order removedOrder = orders.remove(index);
			for (FoodItem order : removedOrder.getFoodItem()) {
				if(order instanceof Pizza) {
					Storage.returnItem(FoodItemName.PIZZA);
				}
			}
		}
	}

	public void displayOrders() {
		for (Order order : orders) {
			System.out.println(order);
		}
	}

	public static void main(String[] args) {

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

		pizzaStore.placeOrder(order);

		pizzaStore.displayOrders();

	}

}
