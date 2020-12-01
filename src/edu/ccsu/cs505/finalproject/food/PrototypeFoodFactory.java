package edu.ccsu.cs505.finalproject.food;

import java.util.HashMap;
import java.util.Map;

/**
 * Part of Prototype pattern
 * is stores and clones stored components when requested
 */
public class PrototypeFoodFactory implements PrototypeFoodFactoryInterface{

	private Map<String, Food> foodLibrary;
	private Map<String, Toppings> toppingsLibrary;
	private Map<String, Food> bundlesLibrary;

	/**
	 *  singleton instance
	 */
	private static PrototypeFoodFactory instance;

	/**
	 * private constructor for Singleton
	 */
	private PrototypeFoodFactory()
	{
		foodLibrary = new HashMap<String, Food>();
		toppingsLibrary = new HashMap<String, Toppings>();
		bundlesLibrary = new HashMap<String, Food>();
	}

	/**
	 * @return singleton instance
	 */
	public static PrototypeFoodFactory getInstance(){
		if(instance == null){
			instance = new PrototypeFoodFactory();
		}
		return instance;
	}

	/**
	 * @param type of food to return
	 * @return foot requested if exists in repository, null otherwise
	 */
	public Food makeFood(String type) {
		Food prototypeFood = foodLibrary.get(type);
		if (prototypeFood != null) {
			return prototypeFood.clone();
		}
		else {
			return null;
		}
	}

	/**
	 * @param type topping to return
	 * @return topping from repository if exists, null otherwise
	 */
	public Toppings makeTopping(String type) {
		Toppings prototypeTopping = toppingsLibrary.get(type);
		if (prototypeTopping != null) {
			return (Toppings) prototypeTopping.clone();
		}
		else {
			return null;
		}
	}

	/**
	 * @param type bundle(Food + Toppings) to return
	 * @return requested bundle if exists in repository, null otherwise
	 */
	public Food makeBundle(String type) {
		Food prototypeFood = bundlesLibrary.get(type);
		if (prototypeFood != null) {
			return prototypeFood.clone();
		}
		else {
			return null;
		}
	}

	/**
	 * @param name key to store Food under
	 * @param food to store in repository for future use
	 */
	public void catalogFood(String name, Food food) {
		foodLibrary.put(name, food);
	}

	/**
	 * @param name key to store Topping under
	 * @param topping to store in repository for future use
	 */
	public void catalogTopping(String name, Toppings topping) {
		toppingsLibrary.put(name, topping);
	}

	/**
	 * @param name key to store bundle under
	 * @param menuName name to be used in Menu
	 * @param food Food with Toppings to store
	 * @param isConfigurable true if we want to use start with no Toppings and have Customer choose them, false it the item is to be used as-is
	 */
	public void catalogBundle(String name, String menuName, Food food, boolean isConfigurable){
		food.isConfigurable = isConfigurable;
		food.menuName = menuName;
		bundlesLibrary.put(name, food);
	}
}
