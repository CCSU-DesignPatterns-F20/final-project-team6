package edu.ccsu.cs505.finalproject.processing;


import edu.ccsu.cs505.finalproject.food.Food;

/**
 * ByPhone is one of the concrete classes that implements orderingstrategy. It is part of the
 * strategy design pattern. Inperson simulates a customer ordering food in person. When order
 * food is called a menu will be shown and a cashier object created. cashier.processorder is
 * called to get the customer's order.
 */
public class ByPhone implements OrderingStrategy {

    /**
     * greet customer, show menu, have cashier take order
     */
    @Override
    public void orderFood() throws Exception {
        System.out.println("phone rings");
        System.out.println("Hello, thank you for calling our restaurant. Here are the items we have today");
        Menu<Food> menu = new Menu.Builder().Build();
        menu.showMenu();
        Cashier cashier=new Cashier();
        cashier.processOrder();
    }

    /**
     *
     * @return returns class name
     */
    @Override
    public String toString() { return this.getClass().getName(); }

    /**
     *
     * @param x compare object x to this object
     * @return boolean response
     */
    @Override
    public boolean equals (Object x)
    { if(x == this) { return true;} else { return false;} }
}
