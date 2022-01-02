package com.pizzastore.main;

import java.util.LinkedList;
import java.util.List;

import com.pizzastore.coffee.Coffee;
import com.pizzastore.orders.FoodItem;
import com.pizzastore.orders.Order;
import com.pizzastore.pizza.CheeseBurstPizza;
import com.pizzastore.pizza.MargheritaPizza;
import com.pizzastore.pizza.Pizza;
import com.pizzastore.pizza.toppings.Mushrooms;
import com.pizzastore.pizza.toppings.Onions;

public class PizzaStore {

	private List<Order> orders;

	public PizzaStore() {
		orders = new LinkedList<>();
	}

	public void placeOrder(Order order) {

		List<FoodItem> foodItems = order.getFoodItem();
		for (FoodItem foodItem : foodItems) {
			foodItem.bake();
		}
		orders.add(order);
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
		order.addFoodItem(new Coffee());

		System.out.println(order.getFinalPrice());
		
		pizzaStore.placeOrder(order);

	}

}
