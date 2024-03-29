package edu.ccsu.cs505.finalproject.food;

/**
 * Grinder, extends abstract Food
 * Part of Abstract Factory pattern
 */
public class Grinder extends Food implements FoodVisitable {

	public Grinder() {
		this.cost = 5.0;
	}

	@Override
	public String name() {
		return "Grinder";
	}

	public Grinder(Double price)
	{
		this.cost = price;
	}

	@Override
	public Food clone() {
		Food clone = new Grinder(this.cost);

		clone.cloneToppings(this);

		clone.isConfigurable = this.isConfigurable;
		clone.menuName = this.menuName;

		return clone;
	}

	/**
	 * Template Pattern, implementation of a hook method
	 * @throws InterruptedException
	 */
	protected void setup() throws InterruptedException {
		System.out.println("Getting the bread out of the box and setting it on the cutting board.");
		Thread.sleep(3000);
		System.out.println("Cutting the bread from end to end using a large, serrated knife.");
		Thread.sleep(3000);
	}

	/**
	 * Template Pattern, implementation of a hook method
	 * @throws InterruptedException
	 */
	protected void cook() throws InterruptedException {
		System.out.println("Preheating the broiler to high heat.");
		Thread.sleep(3000);
		System.out.println("Placing  the grinder under the broiler.");
		Thread.sleep(6000);
		System.out.println("Cheese has melted and grinder is ready to be taken out of broiler.");
		Thread.sleep(3000);
	}

	/**
	 * Template Pattern, implementation of a hook method
	 * @throws InterruptedException
	 */
	protected void slice() throws InterruptedException {
		System.out.println("Slicing grinder in half using the knife.");
		Thread.sleep(3000);

//		grinder is done so notify observers
		notifyObservers(Message.GRINDERDONE);
	}
}
