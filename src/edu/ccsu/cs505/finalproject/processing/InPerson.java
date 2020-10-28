package edu.ccsu.cs505.finalproject.processing;
import java.util.ArrayList;

public class InPerson implements OrderingStrategy {

    /**
     * food selection will be sent to cashier
     */
    @Override
    public void orderFood() throws Exception {

        System.out.println("Hello thank you for coming to our restaurant. Here are the items we have today");
        Menu.showMenu();
        Cashier cashier=new Cashier();
        cashier.processOrder();
    }


//    @Override
//    public String toString() {
//
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
