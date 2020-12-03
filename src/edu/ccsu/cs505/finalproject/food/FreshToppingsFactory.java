package edu.ccsu.cs505.finalproject.food;

/**
 * Part of Abstract Factory pattern
 */
public class FreshToppingsFactory implements ToppingsFactory {

	@Override
	public Toppings makeTopping(String type) throws Exception {
		Toppings topping;
		switch(type)
		{
			case "cheese":
				topping = new Cheese();
				break;
			case "ham":
				topping = new Ham();
				break;
			case "lettuce":
				topping = new Lettuce();
				break;
			case "mushroom":
				topping = new Mushroom();
				break;
			case "pepperoni":
				topping = new Pepperoni();
				break;
			case "peppers":
				topping = new Peppers();
				break;
			case "sausage":
				topping = new Sausage();
				break;
			case "turkey":
				topping = new Turkey();
				break;
			default:
				throw new Exception("Unknown topping type");
		}

		return topping;
	}
}
