package edu.ccsu.cs505.finalproject.processing;
import java.util.ArrayList;

public class InPerson implements OrderingStrategy {
    String foodPick;
    ArrayList<Object> toppingsPick = new ArrayList<Object>();
    public InPerson(String foodItem, ArrayList<Object> toppingsItem) {
        foodPick = foodItem;
        toppingsPick = toppingsItem;
    }
    @Override
    public void orderFood() {
//        send order to cashier
    }
    @Override
    public String toString() {
        return ("The food selection is " + foodPick + " with " + toppingsPick);
    }
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
}
class Test
{
    public static void main(String[] args)
    {
        System.out.println("test");
        String selection = "hamburger";
        ArrayList<Object> top = new ArrayList<Object>();
        top.add("cheese");
        top.add("lettuce");
        InPerson O = new InPerson(selection, top);
        System.out.println("fuck this shit");
        System.out.println(O.toString());
    }
}