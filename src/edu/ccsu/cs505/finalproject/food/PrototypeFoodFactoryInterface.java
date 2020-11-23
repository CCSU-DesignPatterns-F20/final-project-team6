package edu.ccsu.cs505.finalproject.food;

public interface PrototypeFoodFactoryInterface extends FoodFactory{
	public Food makeFood(String name);
	public Toppings makeTopping(String name);
	public Food makeBundle(String name);
	public void catalogFood(String name, Food food);
	public void catalogTopping(String name, Toppings topping);
	public void catalogBundle(String name, Food food, boolean isConfigurable);
}
