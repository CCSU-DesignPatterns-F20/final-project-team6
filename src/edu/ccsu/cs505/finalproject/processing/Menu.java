package edu.ccsu.cs505.finalproject.processing;

import java.util.*;

/**
 * Prints current menu for the customer to choose from
 */
public class Menu<String> {

        public Iterator iterator;

        //menu will be in array
        ArrayList<String> menu = new ArrayList<String>();
        menu.add("Burger");


    private class MenuIterator implements Iterator {

        int index;

        @Override
        public boolean hasNext() {

            if(index < menu.length){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {

            if(this.hasNext()){
                return menu[index++];
            }
            return null;
        }
    }
    public static void showMenu(){
        System.out.println("1. Pizza \n toppings available- pepperoni, mushrooms, sausage, peppers.");
        System.out.println("2. Grinder \n toppings available- lettuce, onions, ham, turkey, cheese, cucumbers.");
    }

}

class test1{
    public static void main(String[] args){

    }
        }