package edu.ccsu.cs505.finalproject.processing;

import java.util.*;

/**
 * Prints current menu for the customer to choose from
 */
public class Menu<String> {

        public Iterator iterator;

        //menu will be in array
//        List<T> menu = new ArrayList<>();
////        menu.add("Pizza");
         List<String> menu;

    public Menu () {
        this.menu = new ArrayList<String>();
//        String item= (String) "pizza";
        this.menu.add((String)"Pizza");
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

class test1{
    public static void main(String[] args){
            Menu m=new Menu();
            System.out.println(m.menu);
    }
        }