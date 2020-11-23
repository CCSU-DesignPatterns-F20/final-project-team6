package edu.ccsu.cs505.finalproject.food;

import java.util.HashMap;
import java.util.Map;

public class PrototypeFoodFactory implements PrototypeFoodFactoryInterface{

	private Map<String, Food> foodLibrary;
	private Map<String, Toppings> toppingsLibrary;
	private Map<String, Food> bundlesLibrary;

	// ** singleton instance
	private static PrototypeFoodFactory instance;

	private PrototypeFoodFactory()
	{
		foodLibrary = new HashMap<String, Food>();
		toppingsLibrary = new HashMap<String, Toppings>();
		bundlesLibrary = new HashMap<String, Food>();
	}

	public static PrototypeFoodFactory getInstance(){
		if(instance == null){
			instance = new PrototypeFoodFactory();
		}
		return instance;
	}

	public Food makeFood(String type) {
		Food prototypeFood = foodLibrary.get(type);
		if (prototypeFood != null) {
			return prototypeFood.clone();
		}
		else {
			return null;
		}
	}

	public Toppings makeTopping(String type) {
		Toppings prototypeTopping = toppingsLibrary.get(type);
		if (prototypeTopping != null) {
			return (Toppings) prototypeTopping.clone();
		}
		else {
			return null;
		}
	}

	public Food makeBundle(String type) {
		Food prototypeFood = bundlesLibrary.get(type);
		if (prototypeFood != null) {
			return prototypeFood.clone();
		}
		else {
			return null;
		}
	}

	public void catalogFood(String name, Food food) {
		foodLibrary.put(name, food);
	}

	public void catalogTopping(String name, Toppings topping) {
		toppingsLibrary.put(name, topping);
	}

	public void catalogBundle(String name, Food food, boolean isConfigurable){
		food.isConfigurable = isConfigurable;
		bundlesLibrary.put(name, food);
	}
}
