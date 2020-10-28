package edu.ccsu.cs505.finalproject.food;

public class Pizza extends Food {

	private String pizzaType;

	@Override
	public String toString() {
		return "Pizza";
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public void prepare() throws InterruptedException {
		System.out.println("Adding flour to the table.");
		Thread.sleep(3000);
		System.out.println("Using the rolling pin to roll out the dough into shape.");
		Thread.sleep(3000);
		System.out.println("Spreading Tomato Sauce on the dough base.");
		Thread.sleep(3000);
		System.out.println("Sprinkling cheese over the cheese.");
		Thread.sleep(3000);
		super.prepare();
	}

	@Override
	void cook() {
		System.out.println("Pizza was placed in the wooden oven and is currently baking.");
	}

	@Override
	void slice() {
		System.out.println("Slicing up the pizza using the pizza cutter");
	}

}
