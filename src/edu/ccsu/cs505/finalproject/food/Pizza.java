package edu.ccsu.cs505.finalproject.food;

/**
 * Pizza, extends abstract Food
 *
 */
public class Pizza extends Food {

	/**
	 * @param obj Object to compare
	 * @return true if equal, false otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Pizza))
		{ return false; }
		else if(obj == this)
		{ return true; }
		else {
			Pizza p = (Pizza) obj;
			return (this.getToppings().equals(((Pizza) obj).getToppings()));}
	}


	/**
	 * @return int hashcode
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
		System.out.println("Pizza is ready to be Served!");
	}

}
