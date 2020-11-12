package edu.ccsu.cs505.finalproject.food;

import edu.ccsu.cs505.finalproject.processing.Observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Defines abstract Food with toppings
 * Part of Abstract Factory pattern and template pattern
 */
public abstract class Food implements Cloneable {

	protected List<Toppings> toppings;
	private List<Observer> ob= new ArrayList<Observer>();
	protected Double cost;

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
	 * @param clone
	 * @return
	 */
	public Food cloneToppings(Food clone)
	{
		for(Toppings topping : this.toppings){
			Toppings top = (Toppings) topping.clone(false);
			clone.addTopping(top);
		}

		return clone;
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
	 * @param deep
	 * @return
	 */
	public abstract Food clone(Boolean deep);

	public double getCost(){
		return cost;
	}

	/**
	 * method to add observer to the observer list for the observer pattern
	 * @param o
	 */
	public void attach(Observer o){
		ob.add(o);
	}

	/**
	 * method to remove observer from observer list for the observer pattern
	 * @param o
	 */
	public void detach(Observer o){
		ob.remove(o);
	}

	/**
	 * method to notify a change to all observers
	 * @param s gives a message about the change
	 */
	public void notifyObservers(String s){
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
			// ** TODO: iterator pattern
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
			System.out.printf("%d. %s\n", itemCount, toppingsIterator.next());
			itemCount++;
		}
	}
}
