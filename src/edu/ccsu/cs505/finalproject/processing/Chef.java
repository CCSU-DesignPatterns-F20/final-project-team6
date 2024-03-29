package edu.ccsu.cs505.finalproject.processing;

import edu.ccsu.cs505.finalproject.food.*;


/**
 * Collects order items and cooks them. Implements the observer interface,
 * chef is updated when food is ready
 */
public class Chef implements Observer {

	private String status;
	private String name;
	public Chef(String name){
		this.name = name;
	}

	/**
	 * @param foodType type of food to cook, pizza or grinder with toppings
	 */
	public void getOrder(Food foodType) throws InterruptedException {
		System.out.println("Chef " + name + " receives order");

//		set status to order received
		status=foodType.getClass().getName()+"order received";
		this.cook(foodType);
	}

	/**
	 *
	 * @param o compare two objects
	 * @return if both objects are equal
	 */
	@Override
	public boolean equals(Object o) {

		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;
		Chef chef = (Chef) o;
		return this.name.equals(chef.name);
	}

	/**
	 *
	 * @return hashcode based on chef name
	 */
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}

	/**
	 *
	 * @return the name of the chef
	 */
	@Override
	public String toString(){
		return this.name;
	}

	/**
	 * @param item to cook
	 *
	 */
	private void cook(Food item) throws InterruptedException {
		item.prepare();
	};

	/**
	 * Will be called when food is ready
	 * @param m will return a message updating the status of the food
	 */
	@Override
	public void update(Food.Message m) {
//		this.status=s;
		System.out.printf("Chef %s yells: %s!", this.name,  m.toString().toUpperCase());
	}
}
