package edu.ccsu.cs505.finalproject.processing;

import edu.ccsu.cs505.finalproject.food.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Prints current menu for the customer to choose from
 */
public class Menu<T extends Food> {

	public Iterator<T> iterator;

	//menu will be in array
	private List<T> items = new ArrayList<T>();

	public Menu() {

	}
  public Iterator<T> iterator(){
        return new MenuIterator();
    }
	public void addItem(T item) {
		this.items.add(item);
	}

	public T getItem(int index){
		return items.get(index);
	}

	public int getMenuSize(){
		return items.size();
	}

	public void printItems() {
		int itemCount=1;
		Iterator<T> menuIterator = this.iterator();

		while (menuIterator.hasNext()) {
			Food f = menuIterator.next();
			System.out.printf("%d. %s %s           $ %,.2f \n", itemCount, f.name(), f.getToppings(),  f.getCost());
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
		public T next() {

			if (this.hasNext()) {
				return items.get(index++);
			}
			return null;
		}
	}

	/**
	 * Helper class that builds restaurant inventory
	 * Part of Prototype Pattern
	 */
	static class Builder {
		Menu<Food> Build() throws Exception {
			ToppingsFactory toppingsFactory = new FreshToppingsFactory();

			PrototypeFoodFactory prototypeFoodFactory = PrototypeFoodFactory.getInstance();

			prototypeFoodFactory.catalogFood("pizza", new Pizza() );
			prototypeFoodFactory.catalogFood("pizza-discounted", new DiscountedFoodDecorator( new Pizza(), 10.00) );
			prototypeFoodFactory.catalogFood("grinder", new Grinder());
			prototypeFoodFactory.catalogTopping("cheese", toppingsFactory.makeTopping("cheese"));
			prototypeFoodFactory.catalogTopping("ham", toppingsFactory.makeTopping("ham"));
			prototypeFoodFactory.catalogTopping("lettuce", toppingsFactory.makeTopping("lettuce"));
			prototypeFoodFactory.catalogTopping("mushroom", toppingsFactory.makeTopping("mushroom"));
			prototypeFoodFactory.catalogTopping("pepperoni", toppingsFactory.makeTopping("pepperoni"));
			prototypeFoodFactory.catalogTopping("sausage", toppingsFactory.makeTopping("sausage"));
			prototypeFoodFactory.catalogTopping("turkey", toppingsFactory.makeTopping("turkey"));

			//===
			Food buildYourOwnPizza = prototypeFoodFactory.makeFood("pizza");
			ArrayList<Toppings> list = new ArrayList<Toppings>();
			list.add(prototypeFoodFactory.makeTopping("cheese"));
			list.add(prototypeFoodFactory.makeTopping("ham"));
			list.add(prototypeFoodFactory.makeTopping("lettuce"));
			list.add(prototypeFoodFactory.makeTopping("mushroom"));
			list.add(prototypeFoodFactory.makeTopping("pepperoni"));
			list.add(prototypeFoodFactory.makeTopping("sausage"));
			list.add(prototypeFoodFactory.makeTopping("turkey"));
			buildYourOwnPizza.setToppings(list);

			prototypeFoodFactory.catalogBundle("build-your-own-pizza", buildYourOwnPizza, true);

			//===
			Food meatloversPizza = prototypeFoodFactory.makeFood("pizza");
			list = new ArrayList<Toppings>();
			list.add(prototypeFoodFactory.makeTopping("cheese"));
			list.add(prototypeFoodFactory.makeTopping("ham"));
			list.add(prototypeFoodFactory.makeTopping("pepperoni"));
			list.add(prototypeFoodFactory.makeTopping("sausage"));
			list.add(prototypeFoodFactory.makeTopping("turkey"));
			meatloversPizza.setToppings(list);

			prototypeFoodFactory.catalogBundle("meatlovers-pizza", meatloversPizza, false);

			//===
			Food cheesePizza = prototypeFoodFactory.makeFood("pizza-discounted");
			list = new ArrayList<Toppings>();
			list.add(prototypeFoodFactory.makeTopping("cheese"));
			cheesePizza.setToppings(list);

			prototypeFoodFactory.catalogBundle("cheese-pizza", cheesePizza, false);

			//===
			Food buildYourOwnGrinder = prototypeFoodFactory.makeFood("grinder");
			list = new ArrayList<Toppings>();
			list.add(prototypeFoodFactory.makeTopping("cheese"));
			list.add(prototypeFoodFactory.makeTopping("ham"));
			list.add(prototypeFoodFactory.makeTopping("lettuce"));
			list.add(prototypeFoodFactory.makeTopping("mushroom"));
			list.add(prototypeFoodFactory.makeTopping("pepperoni"));
			list.add(prototypeFoodFactory.makeTopping("sausage"));
			list.add(prototypeFoodFactory.makeTopping("turkey"));
			buildYourOwnGrinder.setToppings(list);

			prototypeFoodFactory.catalogBundle("build-your-own-grinder", buildYourOwnGrinder, true);

			//===
			Food meatloversGrinder = prototypeFoodFactory.makeFood("grinder");
			list = new ArrayList<Toppings>();
			list.add(prototypeFoodFactory.makeTopping("ham"));
			list.add(prototypeFoodFactory.makeTopping("pepperoni"));
			list.add(prototypeFoodFactory.makeTopping("sausage"));
			list.add(prototypeFoodFactory.makeTopping("turkey"));
			meatloversGrinder.setToppings(list);

			prototypeFoodFactory.catalogBundle("meatlovers-grinder", meatloversGrinder, false);

			//===
			Food plainGrinder = prototypeFoodFactory.makeFood("grinder");
			list = new ArrayList<Toppings>();
			list.add(prototypeFoodFactory.makeTopping("ham"));
			plainGrinder.setToppings(list);

			prototypeFoodFactory.catalogBundle("plain-grinder", plainGrinder, false);

			return createMenu();
		}

		private Menu<Food> createMenu(){
			Menu<Food> menu = new Menu<>();
			PrototypeFoodFactory foodFactory = PrototypeFoodFactory.getInstance();

			menu.addItem( foodFactory.makeBundle("build-your-own-pizza") );
			menu.addItem( foodFactory.makeBundle("meatlovers-pizza") );
			menu.addItem( foodFactory.makeBundle("cheese-pizza") );

			menu.addItem( foodFactory.makeBundle("build-your-own-grinder") );
			menu.addItem( foodFactory.makeBundle("meatlovers-grinder") );
			menu.addItem( foodFactory.makeBundle("plain-grinder") );

			return menu;
		}
	}
}

class test1 {
    public static void main(String[] args) throws Exception {
        Menu<Food> m = new Menu.Builder().Build();

        m.printItems();
    }
}
