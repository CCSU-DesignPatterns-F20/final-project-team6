package edu.ccsu.cs505.finalproject.processing;

import edu.ccsu.cs505.finalproject.food.*;

import java.util.*;

/**
 * Prints current menu for the customer to choose from
 */
public class Menu<T extends Food> {

	public Iterator<T> iterator;

	//menu will be in array
	List<T> items = new ArrayList<T>();

	public Menu() {

	}
  public Iterator<T> iterator(){
        return new MenuIterator();
    }
	public void addItem(T item) {
		this.items.add(item);
	}

	public void printItems() {
		int itemCount=1;
		Iterator<T> menuIterator = this.iterator();

		while (menuIterator.hasNext()) {
			Food f = menuIterator.next();
			System.out.printf("%d. %s            $ %,.2f \n", itemCount, f.name(), f.getCost());
			itemCount++;
		}
	}

	private class MenuIterator implements Iterator<T> {

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

	/**
	 * Helper class that builds restaurant menu
	 */
	static class Builder {
		Menu<Food> Build() throws Exception {
			Menu<Food> menu = new Menu<>();

			FoodFactory foodFactory = new FreshFoodFactory();

			Food pizza = new DiscountedFoodDecorator(foodFactory.makeFood("pizza"), 10.00);
			pizza.addTopping(new Pepperoni());
			pizza.addTopping(new Mushroom());
			pizza.addTopping(new Sausage());
			pizza.addTopping(new Peppers());

			menu.addItem(pizza);

			Food grinder = foodFactory.makeFood("grinder");
			grinder.addTopping(new Lettuce());
			grinder.addTopping(new Ham());
			grinder.addTopping(new Turkey());
			grinder.addTopping(new Cheese());


			menu.addItem(grinder);

			return menu;
		}
	}
}

class test1 {
    public static void main(String[] args) throws Exception {
        Menu<Food> m = new Menu.Builder().Build();
        Iterator<Food> menuIterator = m.iterator();

        System.out.println(menuIterator.hasNext());
        while (menuIterator.hasNext()) {
            System.out.println(menuIterator.next());
        }
    }
}
