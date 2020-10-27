package edu.ccsu.cs505.finalproject.processing;
import java.util.ArrayList;

public class InPerson implements OrderingStrategy {

    Customer C;

    public InPerson(Customer customer) {
        C=customer;
    }

    /**
     * food selection will be sent to cashier
     */
    @Override
    public void orderFood() {

        System.out.println("Hello " + C.name + " thank you for coming to our restaurant. Here are the items we have today");
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
