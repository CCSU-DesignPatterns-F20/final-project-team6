package edu.ccsu.cs505.finalproject.processing;

import edu.ccsu.cs505.finalproject.food.Food;


/**
 * Collects order items and cooks them
 */
public class Chef {
	// TODO:
//	CookingStrategy strategy;

	String name;

	public Chef(String name){
		this.name = name;
	}

	/**
	 * @param foodType type of food to cook, pizza or grinder with toppings
	 */
	public void getOrder(Food foodType) throws InterruptedException {
		System.out.println("Chef " + name + " receives order");
//		cook food
		this.cook(foodType);
	}

	@Override
	public boolean equals(Object o) {

		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;
		Chef chef = (Chef) o;
		return this.name.equals(chef.name);
	}

	@Override
	public int hashCode() {
		return this.name.hashCode();
	}


	/**
	 * @param item to cook
	 *
	 */
	private void cook(Food item) throws InterruptedException {
		item.prepare();
	};
}
