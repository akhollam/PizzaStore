package com.pizzastore.pizza;

import java.util.ArrayList;
import java.util.List;

import com.pizzastore.orders.FoodItem;
import com.pizzastore.pizza.crust.PizzaCrusts;
import com.pizzastore.pizza.crust.ThinCrust;
import com.pizzastore.pizza.toppings.Toppings;

public abstract class Pizza implements FoodItem {

	private String name;
	private List<Toppings> toppings;
	private List<Toppings> extra;
	protected PizzaCrusts pizzaCrusts;

	public Pizza(String name) {
		this.name = name;
		this.toppings = new ArrayList<>();
		this.extra = new ArrayList<>();
		pizzaCrusts = new ThinCrust();
	}

	public Pizza() {

	}

	public void bake() {
		
		// default toppings 

	}

	public void setPizzaCrusts(PizzaCrusts pizzaCrusts) {
		this.pizzaCrusts = pizzaCrusts;
	}

	public void addToppings(Toppings toppings) {
		this.toppings.add(toppings);
	}
	
	public void addExtra(Toppings toppings) {
		this.extra.add(toppings);
	}
	
	public String getName() {
		return name;
	}

	public double getPrice() {

		double price = getBasePrice();
		price += pizzaCrusts.getPrice();
		
		for (Toppings toppings2 : toppings) {
			price += toppings2.getPrice();
		}

		for (Toppings extraToppings : extra) {
			price += extraToppings.getPrice();
		}
		
		return price;
	}

	public abstract double getBasePrice();

	@Override
	public String toString() {
		String allToppings = "";
		
		for (Toppings topping : toppings) {
			allToppings += topping.getName() + ", ";
		}
		
		for (Toppings topping : extra) {
			allToppings += topping.getName() + ", ";
		}
		
		return this.name + " with [" + allToppings + "] is ready.";
	}

}
