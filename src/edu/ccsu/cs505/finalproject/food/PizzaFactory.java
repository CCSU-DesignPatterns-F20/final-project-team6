package edu.ccsu.cs505.finalproject.food;

public class PizzaFactory implements MealFactory {
	@Override
	public Food makeFood() {
		return new Pizza();
	}
}
