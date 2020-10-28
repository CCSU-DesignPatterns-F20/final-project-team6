package edu.ccsu.cs505.finalproject.food;

import java.util.List;

public abstract class Food {

	private List<String> toppings;

	public void prepare() throws InterruptedException {
		gatherToppings();
		placeToppings();
		cook();
		slice();
	}

	private void gatherToppings() {

	}

	private void placeToppings() {

	}

	abstract void cook();

	abstract void slice();
}
