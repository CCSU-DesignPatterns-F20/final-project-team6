package edu.ccsu.cs505.finalproject.processing;

import edu.ccsu.cs505.finalproject.food.Food;

public class Chef {
	// TODO:
//	CookingStrategy strategy;

	String name;

	public Chef(String name){
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {

		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;
		Chef chef = (Chef) o;
		return this.name.equals(((Chef) o).name);
	}

	@Override
	public int hashCode() {
		return this.name.hashCode();
	}


	/**
	 * @param item to cook
	 * @return cooked item
	 */
	public Food cook(Food item){
		return item;
	}
}
