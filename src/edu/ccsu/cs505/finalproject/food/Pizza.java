package edu.ccsu.cs505.finalproject.food;

public class Pizza extends Food {

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

	void cook() throws InterruptedException {
		System.out.println("Pizza was placed in the wooden oven and is currently baking.");
		Thread.sleep(6000);
		System.out.println("Pizza is done baking.");
		Thread.sleep(3000);
	}

	void slice() throws InterruptedException {
		System.out.println("Slicing up the pizza using the pizza cutter.");
		Thread.sleep(3000);
		System.out.println("Pizza is ready to be Served!");
	}

}
