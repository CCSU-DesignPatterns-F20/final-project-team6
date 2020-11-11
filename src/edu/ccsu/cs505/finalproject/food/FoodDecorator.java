package edu.ccsu.cs505.finalproject.food;

import edu.ccsu.cs505.finalproject.processing.Observer;

public abstract class FoodDecorator extends Food{
	protected Food decoratedFood;

	public FoodDecorator(Food food) {
		this.decoratedFood = food;
	}

	public double getCost()
	{
		return this.decoratedFood.getCost();
	}

	/**
	 * method to add observer to the observer list for the observer pattern
	 * @param o
	 */
	public void attach(Observer o){
		decoratedFood.attach(o);
	}

	/**
	 * method to remove observer from observer list for the observer pattern
	 * @param o
	 */
	public void detach(Observer o){
		decoratedFood.detach(o);
	}
}
