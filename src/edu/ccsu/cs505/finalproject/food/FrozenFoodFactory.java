package edu.ccsu.cs505.finalproject.food;

/**
 * Part of Abstract Factory pattern, produces frozen Food
 */
public class FrozenFoodFactory implements MealFactory {
	private String type;

	/**
	 * Currently not used
	 * @return Pizza
	 */
	@Override
	public Food makeFood(String type) {
		this.type = type;
		return new Pizza();
	}
}
