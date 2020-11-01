package edu.ccsu.cs505.finalproject.food;

/**
 * Grinder, extends abstract Food
 */
public class Grinder extends Food {

	/**
	 * @param obj Object to compare
	 * @return true if equal, false otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	/**
	 * @return int
	 */
	@Override
	public int hashCode() {
		return super.hashCode();
	}


	/**
	 * @throws InterruptedException
	 */
	@Override
	public void prepare() throws InterruptedException {
		System.out.println("Getting the bread out of the box and setting it on the cutting board.");
		Thread.sleep(3000);
		System.out.println("Cutting the bread from end to end using a large, serrated knife.");
		Thread.sleep(3000);
		super.prepare();
	}

	/**
	 * Template Pattern, implementation of a hook method
	 * @throws InterruptedException
	 */
	void cook() throws InterruptedException {
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
	void slice() throws InterruptedException {
		System.out.println("Slicing grinder in half using the knife.");
		Thread.sleep(3000);
		System.out.println("Grinder is ready to be Served!");
		Thread.sleep(3000);
	}
}
