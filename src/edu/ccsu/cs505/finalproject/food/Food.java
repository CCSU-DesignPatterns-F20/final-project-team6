package edu.ccsu.cs505.finalproject.food;

import edu.ccsu.cs505.finalproject.processing.Observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Defines abstract Food with toppings
 * Part of Abstract Factory pattern and template pattern
 */
public abstract class Food implements Cloneable, FoodVisitable {

	protected List<Toppings> toppings;
	private List<Observer> ob= new ArrayList<Observer>();
	protected Double cost;
	protected String menuName;
	protected boolean isConfigurable = false;

	/**
	 * constructor
	 */
	public Food()
	{
		this.toppings = new ArrayList<Toppings>();
	}

	/**
	 * @return name of the food
	 */
	public abstract String name();

	/**
	 * @param original object to copy toppings from
	 * @return the original Food
	 */
	public Food cloneToppings(Food original)
	{
		for(Toppings topping : original.toppings){
			Toppings top = (Toppings) topping.clone();
			this.addTopping(top);
		}

		return original;
	}

	/**
	 * @param toppings list of toppings to add
	 */
	public void setToppings(List<Toppings> toppings){
		this.toppings = toppings;
	}


	/**
	 * constructor
	 */
	public Food(Double price){
		this.cost = price;
	};

	/**
	 * @return cloned object
	 */
	public abstract Food clone();

	/**
	 * @return the cost of Food
	 */
	public double getCost(){
		return cost;
	}

	/**
	 * method to add observer to the observer list for the observer pattern
	 * will notify each observer when food is ready
	 * @param o observer to attach
	 */
	public void attach(Observer o){
		ob.add(o);
	}

	/**
	 * method to remove observer from observer list for the observer pattern
	 * @param o observer to detach
	 */
	public void detach(Observer o){
		ob.remove(o);
	}

	/**
	 * method to notify all observers when the food is done cooking/ready
	 * @param s gives a message about the change
	 */
	public void notifyObservers(Message s){
		for (Observer x: ob){
			x.update(s);
		}
	}
	/**
	 * Template method for food preparation with hook methods
	 * @throws InterruptedException
	 */
	public void prepare() throws InterruptedException {
		setup();
		placeToppings();
		cook();
		slice();
	}

	/**
	 * @param topping list of food toppings as Strings
	 */
	public void addTopping(Toppings topping){
		this.toppings.add( topping );
	}

	/**
	 * @return list of toppings
	 */
	public List<Toppings> getToppings()
	{
		return this.toppings;
	}

	/**
	 * Prints each topping as it is being prepared
	 * @throws InterruptedException
	 */
	private void placeToppings() throws InterruptedException {
		for ( Toppings topping : toppings) {
			System.out.println(("Adding " + topping));
			Thread.sleep(3000);

		}
	}

	/**
	 * @return string representation of child food classes
	 */
	public String toString()
	{
		StringBuilder result = new StringBuilder(this.name());

		if(!this.toppings.isEmpty()){
			result.append("[toppings:");

			Iterator<Toppings> toppingsIterator = this.toppings.iterator();

			while(toppingsIterator.hasNext())
			{
				result.append( toppingsIterator.next() );

				if(toppingsIterator.hasNext())
				{
					result.append(",");
				}
			}
			result.append("]");
		}

		return result.toString();
	}

	public String getMenuName() {
		return menuName;
	}

	/**
	 * @return int
	 */
	@Override
	public int hashCode() {
		return this.getToppings().hashCode();
	}

	/**
	 * @param obj Object to compare
	 * @return true if equal, false otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Food)){
			return false;
		}

		if( !this.getClass().toString().equalsIgnoreCase(obj.getClass().toString()) ){
			return false;
		}
		if(obj == this){
			return true;
		}
		else {
			Food food = (Food) obj;
			return (this.getToppings().equals(((Food) food).getToppings()));}
	}

	/**
	 * Abstract hook method for Template Pattern, it needs to be implemented by all food items
	 * Initial steps before preparing food
	 */
	protected abstract void setup() throws InterruptedException;

	/**
	 * Template Pattern's hook method used in prepare() method
	 * it needs to be implemented by all food items
	 * @throws InterruptedException
	 */
	protected abstract void cook() throws InterruptedException;

	/**
	 * Template Pattern's hook method used in prepare() method
	 * it needs to be implemented by all food items
	 * @throws InterruptedException
	 */
	protected abstract void slice() throws InterruptedException;

	/**
	 * prints Food item toppings to choose from
	 */
	public void printToppings() {
		int itemCount=1;

		Iterator<Toppings> toppingsIterator = this.toppings.listIterator();

		while (toppingsIterator.hasNext()) {
			Toppings t=toppingsIterator.next();
			System.out.printf("%d. %s            $ %,.2f \n", itemCount, t, t.getCost());
			itemCount++;
		}
	}

	/**
	 * @return true if the food item is a build-you-own type, false if it can only be sold as-is
	 */
	public boolean isConfigurable(){
		return isConfigurable;
	}

	/**
	 * @param configurable set to false one configurable item is configured
	 */
	public void setIsConfigurable(boolean configurable){
		this.isConfigurable = configurable;
	}

	/**
	 * public void accept, accepts visitor of type FoodVisitor
	 * @param visitor part of Visitor pattern
	 */
	public void accept(FoodVisitor visitor) {
		visitor.visitFood(this);

		// ** only visit toppings if item is not configurable
		if(!this.isConfigurable){
			for(Toppings topping:this.getToppings()){
				topping.accept(visitor);
			}
		}
	}

	public enum Message
	{
		PIZZADONE("Pizza is ready"),
		GRINDERDONE("Grinder is ready");
		String m;

		private Message(String m)
		{
			this.m=m;
		}
		public String toString()
		{
			return m;
		}
	}
}
