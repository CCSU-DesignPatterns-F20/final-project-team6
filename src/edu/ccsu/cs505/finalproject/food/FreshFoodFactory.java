package edu.ccsu.cs505.finalproject.food;

public class FreshFoodFactory implements MealFactory {
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
		return new Grinder();
	}
}
