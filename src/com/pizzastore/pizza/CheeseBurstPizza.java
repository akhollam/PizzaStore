package com.pizzastore.pizza;

import com.pizzastore.exceptions.OutOfStockException;
import com.pizzastore.orders.FoodItemName;
import com.pizzastore.pizza.crust.ThickCrustPizza;
import com.pizzastore.pizza.toppings.BlackOlives;
import com.pizzastore.pizza.toppings.GreenPeppers;
import com.pizzastore.pizza.toppings.Mushrooms;
import com.pizzastore.pizza.toppings.Onions;
import com.pizzastore.pizza.toppings.Pepperoni;
import com.pizzastore.store.Storage;

public class CheeseBurstPizza extends Pizza {

	private CheeseType cheeseType;
	private static final double BASE_PRICE = 800;
	
	public CheeseBurstPizza() {
		super("Cheese Burst Pizza");
		cheeseType = new ChipotleCheese();
	}

	public CheeseBurstPizza(CheeseType type) {
		super("Cheese Burst Pizza");
		this.cheeseType = type;
	}

	@Override
	public void bake() throws OutOfStockException {
		
		Storage.get(FoodItemName.PIZZA);
		
		this.setPizzaCrusts(new ThickCrustPizza());
		this.addToppings(new Pepperoni());
		this.addToppings(new Mushrooms());
		this.addToppings(new Onions());
		this.addToppings(new GreenPeppers());
		this.addToppings(new BlackOlives());
	}


	@Override
	public double getBasePrice() {
		return BASE_PRICE + this.cheeseType.getPrice();
	}

}
