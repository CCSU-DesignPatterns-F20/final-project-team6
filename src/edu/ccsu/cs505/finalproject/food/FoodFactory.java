package edu.ccsu.cs505.finalproject.food;

/**
 * Part of Abstract Factory pattern, interface implemented by all Food factories
 */
public interface FoodFactory {

	/**
	 * Produces different types of Food based on input
	 * @param type of Food object to be created
	 * @return Food
	 * @throws Exception when unrecognized food type is passed in as a parameter
	 */
	public Food makeFood(String type) throws Exception;
}
