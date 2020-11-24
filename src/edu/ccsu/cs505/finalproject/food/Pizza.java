package edu.ccsu.cs505.finalproject.food;


/**
 * Pizza, extends abstract Food
 * Part of Abstract Factory pattern
 */

public class Pizza extends Food {

	/**
	 * Pizza constructor
	 */
	public Pizza() {
		this.cost = 20.0;
	}

	@Override
	public String name() {
		return "Pizza";
	}

	public Pizza(double price) {
		this.cost = price;
	}

	@Override
	public Food clone() {
		Food clone = new Pizza(this.cost);

		clone.cloneToppings(this);

		clone.isConfigurable = this.isConfigurable;

		return clone;
	}

	/**
	 * Template Pattern, implementation of a hook method
	 * @throws InterruptedException
	 */
	protected void setup() throws InterruptedException {
		System.out.println("Adding flour to the table.");
		Thread.sleep(3000);
		System.out.println("Using the rolling pin to roll out the dough into shape.");
		Thread.sleep(3000);
		System.out.println("Spreading Tomato Sauce on the dough base.");
		Thread.sleep(3000);
		System.out.println("Sprinkling cheese over the cheese.");
		Thread.sleep(3000);
	}

	/**
	 * Template Pattern, implementation of a hook method
	 * @throws InterruptedException
	 */
	protected void cook() throws InterruptedException {
		System.out.println("Pizza was placed in the wooden oven and is currently baking.");
		Thread.sleep(6000);
		System.out.println("Pizza is done baking.");
		Thread.sleep(3000);
	}

	/**
	 * Template Pattern, implementation of a hook method
	 * @throws InterruptedException
	 */
	protected void slice() throws InterruptedException {
		System.out.println("Slicing up the pizza using the pizza cutter.");
		Thread.sleep(3000);
//		String done="Pizza is ready";

//		pizza is done so notify observers
		notifyObservers(Message.PIZZADONE);
	}

}

class test63{
	public static void main(String [] args){
	System.out.println(Food.Message.PIZZADONE);
	}
}