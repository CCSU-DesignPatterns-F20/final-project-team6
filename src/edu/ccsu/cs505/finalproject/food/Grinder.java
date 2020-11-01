package edu.ccsu.cs505.finalproject.food;

public class Grinder extends Food {

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
		System.out.println("Getting the bread out of the box and setting it on the cutting board.");
		Thread.sleep(3000);
		System.out.println("Cutting the bread from end to end using a large, serrated knife.");
		Thread.sleep(3000);
		super.prepare();
	}

	void cook() throws InterruptedException {
		System.out.println("Preheating the broiler to high heat.");
		Thread.sleep(3000);
		System.out.println("Placing  the grinder under the broiler.");
		Thread.sleep(6000);
		System.out.println("Cheese has melted and grinder is ready to be taken out of broiler.");
		Thread.sleep(3000);
	}

	void slice() throws InterruptedException {
		System.out.println("Slicing grinder in half using the knife.");
		Thread.sleep(3000);
		System.out.println("Grinder is ready to be Served!");
		Thread.sleep(3000);
	}
}
