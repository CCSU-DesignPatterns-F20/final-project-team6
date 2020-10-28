package edu.ccsu.cs505.finalproject.processing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ByPhone implements OrderingStrategy {



    /**
     * answer phone, give menu, take order
     */
    @Override
    public void orderFood() {
        System.out.println("phone rings");
        System.out.println("Hello, thank you for calling our restaurant. Here are the items we have today");

        Menu.showMenu();
        Cashier cashier=new Cashier();
        cashier.processOrder();
    }

    /**
     *
     * @return returns food and toppings
     */
//    @Override
//    public String toString() {
//        return ("The food selection is " + foodPick + " with " + toppingsPick);
//    }

    /**
     *
     * @param x compare object x to this object
     * @return boolean response
     */
//    @Override
//    public boolean equals (Object x)
//    {
//        if(!(x instanceof InPerson)) { return false;}
//        else if(x == this) { return true;}
//        else {
//            InPerson in = (InPerson) x;
//            return (in.foodPick.equals(this.foodPick)) && (in.toppingsPick.equals(this.toppingsPick));
//        }
//    }

    /**
     *
     * @return hashcode
     */
    @Override
    public int hashCode()
    {
//        will add proper hashcode
        return 0;
    }
}
