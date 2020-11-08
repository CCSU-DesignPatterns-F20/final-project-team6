package edu.ccsu.cs505.finalproject.food;

import edu.ccsu.cs505.finalproject.processing.Observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Defines abstract Food with toppings
 * Part of Abstract Factory pattern
 */
public abstract class Food {

	private List<String> toppings;
	private List<Observer> ob= new ArrayList();

	/**
	 * constructor
	 */
	public Food()
	{
		this.toppings = new ArrayList<String>();
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
	 * @param s return a message about the change
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
	public void addTopping(String topping){
		this.toppings.add( topping );
	}

	/**
	 * @return list of toppings
	 */
	public List<String> getToppings()
	{
		return this.toppings;
	}

	/**
	 * Prints each topping as it is being prepared
	 * @throws InterruptedException
	 */
	private void placeToppings() throws InterruptedException {
		for ( String topping : toppings) {
			System.out.println(("Adding " + topping));
			Thread.sleep(3000);

		}
	}

	/**
	 * @return string representation of child food classes
	 */
	public String toString()
	{
		StringBuilder result = new StringBuilder(this.getClass().getSimpleName());

		if(!this.toppings.isEmpty()){
			result.append("[toppings:");
			// ** TODO: iterator pattern
			Iterator<String> toppingsIterator = this.toppings.iterator();

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
}

class test2{
	public static void main(String[]args){
		Food f=new Pizza();
		f.addTopping("oijij");
	}
}