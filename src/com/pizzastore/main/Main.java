package com.pizzastore.main;

import com.pizzastore.coffee.Americano;
import com.pizzastore.coffee.Cappuccino;
import com.pizzastore.coffee.Latte;
import com.pizzastore.exceptions.OrderAlreadyPlacedException;
import com.pizzastore.frenchfries.FrenchFries;
import com.pizzastore.frenchfries.Size;
import com.pizzastore.orders.Order;
import com.pizzastore.payments.CashPayment;
import com.pizzastore.payments.exceptions.PaymentFailedException;
import com.pizzastore.pizza.CheeseBurstPizza;
import com.pizzastore.pizza.MargheritaPizza;
import com.pizzastore.pizza.Pizza;
import com.pizzastore.pizza.toppings.Mushrooms;
import com.pizzastore.pizza.toppings.Onions;
import com.pizzastore.store.Storage;

public class Main {
	
	public static void main(String[] args) {
		
		PizzaStore pizzaStore = new PizzaStore();

		for (int i = 0; i < 12; i++) {

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

				// pizzaStore.placeOrder(order, new CardPayment("13123-132-123-123"));
				
				pizzaStore.placeOrder(order, new CashPayment());
				// pizzaStore.placeOrder(new Order(), new CashPayment());
				// pizzaStore.placeOrder(new Order(), new CashPayment());
				
				pizzaStore.displayOrders();
				// Order orderToBeModified = pizzaStore.modifyOrder(order.getOrderId());
				// orderToBeModified.addFoodItem(new FrenchFries(Size.LARGE));

			} catch (PaymentFailedException e) {
				
				System.err.println("Payment failed. Cannot place order." + e.getMessage());
				
			} catch (OrderAlreadyPlacedException e) {
				
				e.printStackTrace();
			} 

			pizzaStore.displayOrders();

			// pizzaStore.cancelOrder(order.getOrderId());
			// pizzaStore.displayOrders();

			Storage.displayAvailability();

			System.out.println("\n**********************************************************\n");

		}
	}

}
