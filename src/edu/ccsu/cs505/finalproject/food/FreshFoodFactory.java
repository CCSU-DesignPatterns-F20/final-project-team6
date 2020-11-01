package edu.ccsu.cs505.finalproject.food;

/**
 * Part of Abstract Factory pattern
 */
public class FreshFoodFactory implements FoodFactory {
	/**
	 * Produces different types of fresh Food
	 * @param type String type of food, "pizza" or "grinder"
	 * @return Food, Pizza or Grinder
	 * @throws Exception when unrecognized food type is passed in as a parameter
	 */
	@Override
	public Food makeFood(String type) throws Exception {
		Food food;
		switch(type)
		{
			case "pizza":
				food = new Pizza();
				break;
			case "grinder":
				food = new Grinder();
				break;
			default:
				throw new Exception("Unknown food type");
		}
		return food;
	}
}
