package edu.ccsu.cs505.finalproject.food;

public class FrozenFoodFactory implements MealFactory {
	@Override
	public Food makeFood(String type) {
		return new Pizza();
	}
}
