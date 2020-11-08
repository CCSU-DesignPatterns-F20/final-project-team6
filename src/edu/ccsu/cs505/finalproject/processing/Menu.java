package edu.ccsu.cs505.finalproject.processing;

import java.util.*;

/**
 * Prints current menu for the customer to choose from
 */
public class Menu {

        public Iterator iterator;

        //menu will be in array
        private List<String> menu;

        public Menu () {
            this.menu = new ArrayList<String>();
            this.menu.add("Pizza");
        }

    private class MenuIterator implements Iterator {

        int index;

        @Override
        public Boolean hasNext() {

            if(index < menu.size()){
                return true;
            }
            return false;
        }

        @Override
        public void remove() {

        }



        @Override
        public String next() {

            if(this.hasNext()){
                return menu.get(index++);
            }
            return null;
        }
    }

    public static void showMenu(){
        System.out.println("1. Pizza \n toppings available- pepperoni, mushrooms, sausage, peppers.");
        System.out.println("2. Grinder \n toppings available- lettuce, onions, ham, turkey, cheese, cucumbers.");
    }

}