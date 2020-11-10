package edu.ccsu.cs505.finalproject.food;

public abstract class FoodDecorator extends Food{
	protected Food decoratedFood;

	public FoodDecorator(Food food) {
		this.decoratedFood = food;
	}

	public double getCost()
	{
		return this.decoratedFood.getCost();
	}
}
