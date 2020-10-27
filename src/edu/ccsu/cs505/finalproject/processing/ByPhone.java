package edu.ccsu.cs505.finalproject.processing;

import java.util.ArrayList;

public class ByPhone implements OrderingStrategy {

    String foodPick;
    ArrayList<Object> toppingsPick = new ArrayList<Object>();

    /**
     *
     * @param foodItem item the customer select (pizza or grinder)
     * @param toppingsItem arraylist of toppings for that item
     */

    public ByPhone(String foodItem, ArrayList<Object> toppingsItem) {
        foodPick = foodItem;
        toppingsPick = toppingsItem;
    }

    /**
     * food selection will be sent to cashier
     */
    @Override
    public void orderFood() {
//        pick up phone
//        send order to cashier
    }

    /**
     *
     * @return returns food and toppings
     */
    @Override
    public String toString() {
        return ("The food selection is " + foodPick + " with " + toppingsPick);
    }

    /**
     *
     * @param x compare object x to this object
     * @return boolean response
     */
    @Override
    public boolean equals (Object x)
    {
        if(!(x instanceof InPerson)) { return false;}
        else if(x == this) { return true;}
        else {
            InPerson in = (InPerson) x;
            return (in.foodPick.equals(this.foodPick)) && (in.toppingsPick.equals(this.toppingsPick));
        }
    }

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
class Test2
{
    public static void main(String[] args)
    {
        System.out.println("test");
        String selection = "grinder";
        ArrayList<Object> top = new ArrayList<Object>();
        top.add("cheese");
        top.add("lettuce");
        ByPhone O = new ByPhone(selection, top);

        String selection2 = "pizza";
        ArrayList<Object> top2 = new ArrayList<Object>();
        top2.add("mushrooms");
        top2.add("sausage");
        ByPhone O2 = new ByPhone(selection2, top2);

        System.out.println("Does 1 and 2 equal? " + O.equals(O2));
        System.out.println(O.toString());
        System.out.println(O2.toString());

    }
}
