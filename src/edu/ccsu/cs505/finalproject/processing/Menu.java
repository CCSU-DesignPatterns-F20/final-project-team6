package edu.ccsu.cs505.finalproject.processing;

import edu.ccsu.cs505.finalproject.food.Food;
import edu.ccsu.cs505.finalproject.food.Grinder;
import edu.ccsu.cs505.finalproject.food.Pizza;

import java.util.*;

/**
 * Prints current menu for the customer to choose from
 */
public class Menu<T extends Food> {

	public Iterator iterator;

	//menu will be in array
	List<T> items = new ArrayList<T>();

	public Menu() {

	}
    public Iterator iterator(){
        return new MenuIterator();
    }
	public void addItem(T item) {
		this.items.add(item);
	}

	private class MenuIterator implements Iterator {

		int index;

		@Override
		public Boolean hasNext() {

			if (index < items.size()) {
				return true;
			}
			return false;
		}

		@Override
		public void remove() {

		}


		@Override
		public T next() {

			if (this.hasNext()) {
				return items.get(index++);
			}
			return null;
		}
	}

	static class Builder {
		Menu<Food> Build() {
			Menu<Food> menu = new Menu<Food>();

			Pizza pizza = new Pizza();
			pizza.addTopping("Pepperoni");
			pizza.addTopping("Mushrooms");
			pizza.addTopping("Sausage");
			pizza.addTopping("Peppers");

			menu.addItem(pizza);

			Grinder grinder = new Grinder();
			grinder.addTopping("Lettuce");
			grinder.addTopping("Ham");
			grinder.addTopping("Turkey");
			grinder.addTopping("Cheese");


			menu.addItem(grinder);

			return menu;
		}
	}
}

class test1 {
    public static void main(String[] args) {
        Menu<Food> m = new Menu.Builder().Build();
        Iterator menuIterator = m.iterator();

        System.out.println(menuIterator.hasNext());
        while (menuIterator.hasNext()) {
            System.out.println(menuIterator.next());
        }
    }
}
