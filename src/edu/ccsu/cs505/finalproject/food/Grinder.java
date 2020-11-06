package edu.ccsu.cs505.finalproject.food;

/**
 * Grinder, extends abstract Food
 * Part of Abstract Factory pattern
 */
public class Grinder extends Food {

	/**
	 * @param obj Object to compare
	 * @return true if equal, false otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Grinder))
		{ return false; }
		else if(obj == this)
		{ return true; }
		else {
			Grinder g = (Grinder) obj;
			return (this.getToppings().equals(((Grinder) obj).getToppings()));}
	}

	/**
	 * @return int
	 */
	@Override
	public int hashCode() {
		return super.getToppings().hashCode();
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
		String done="Grinder is ready to be Served!";

//		pizza is done so notify observers
		notifyObservers(done);
	}
}
