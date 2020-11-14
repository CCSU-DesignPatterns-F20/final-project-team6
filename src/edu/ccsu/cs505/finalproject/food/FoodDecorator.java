package edu.ccsu.cs505.finalproject.food;

import edu.ccsu.cs505.finalproject.processing.Observer;

import java.util.List;

/**
 * Generic Decorator for Food class
 */
public abstract class FoodDecorator extends Food{
	protected Food decoratedFood;

	/**
	 * @param food object to be decorated
	 */
	public FoodDecorator(Food food) {
		this.decoratedFood = food;
	}

	/**
	 * @return cost of food
	 */
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

	/**
	 * @param topping list of food toppings as Strings
	 */
	public void addTopping(Toppings topping){
		this.decoratedFood.addTopping( topping );
	}

	/**
	 * @return list of toppings
	 */
	public List<Toppings> getToppings()
	{
		return this.decoratedFood.toppings;
	}

	/**
	 * @param toppings list of toppings to add
	 */
	public void setToppings(List<Toppings> toppings){
		this.decoratedFood.toppings = toppings;
	}

	public void printToppings() {
		this.decoratedFood.printToppings();
	}

	@Override
	public String name() {
		return decoratedFood.name();
	}

	@Override
	protected void setup() throws InterruptedException {
		this.decoratedFood.setup();
	}

	@Override
	protected void cook() throws InterruptedException {
		this.decoratedFood.cook();
	}

	@Override
	protected void slice() throws InterruptedException {
		this.decoratedFood.slice();
	}

	@Override
	public String toString() {
		String test = super.toString();
		return this.decoratedFood.toString();
	}
}
