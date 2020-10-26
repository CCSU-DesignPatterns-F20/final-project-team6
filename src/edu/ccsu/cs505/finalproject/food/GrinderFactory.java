package edu.ccsu.cs505.finalproject.food;

public class GrinderFactory implements MealFactory {
	@Override
	public Food makeFood() {
		return new Grinder();
	}
}
