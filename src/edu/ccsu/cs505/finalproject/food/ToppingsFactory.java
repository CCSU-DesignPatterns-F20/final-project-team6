package edu.ccsu.cs505.finalproject.food;

/**
 * Part of Abstract Factory pattern, interface implemented by all Food factories
 */
public interface ToppingsFactory {

	/**
	 * Produces different types of Toppings based on input
	 * @param type of Toppings object to be created
	 * @return Toppings
	 * @throws Exception when unrecognized topping type is passed in as a parameter
	 */
	Toppings makeTopping(String type) throws Exception;

}
