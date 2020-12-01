package edu.ccsu.cs505.finalproject.food;

/**
 * Part of Prototype pattern
 * interface of PrototypeFoodFactory
 */
public interface PrototypeFoodFactoryInterface extends FoodFactory{
	Toppings makeTopping(String name);
	Food makeBundle(String name);
	void catalogFood(String name, Food food);
	void catalogTopping(String name, Toppings topping);
	void catalogBundle(String name, String menuName, Food food, boolean isConfigurable);
}
