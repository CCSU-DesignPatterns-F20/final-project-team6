package edu.ccsu.cs505.finalproject.processing;

public class ByPhone implements OrderingStrategy {



    /**
     * answer phone, give menu, take order
     */
    @Override
    public void orderFood() throws Exception {
        System.out.println("phone rings");
        System.out.println("Hello, thank you for calling our restaurant. Here are the items we have today");
        Menu.showMenu();
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
