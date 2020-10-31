package edu.ccsu.cs505.finalproject.food;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Food {

	private List<String> toppings;

	public Food()
	{
		this.toppings = new ArrayList<String>();
	}

	public void prepare() throws InterruptedException {
		placeToppings();
		cook();
		slice();
	}

	public void addTopping(String topping){
		this.toppings.add( topping );
	}

	public List<String> getToppings()
	{
		return this.toppings;
	}

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

	private void placeToppings() {

	}

	abstract void cook() throws InterruptedException;

	abstract void slice() throws InterruptedException;
}
