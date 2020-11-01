package edu.ccsu.cs505.finalproject.processing;

/**
 * This Customer class represents the customer in the restaurant simulator. It is the "client"
 * part of the strategy design pattern. Customer is given two attributes, a name
 * and an ordering strategy.
 *
 * orderfood method will start the ordering process by sending the customer over to the strategy
 * the customer has selected.
 */
public class Customer {

    private String name="";
    private OrderingStrategy strategy;

    /**
     *
     * @param firstName attach name to customer
     * @param s type of order the customer will be making
     */
    public Customer(String firstName, OrderingStrategy s){
        name=firstName;
        strategy=s;
    }

    /**
     * order food based on strategy selected
     */
    public void orderFood() throws Exception { strategy.orderFood();}

    /**
     *
     * @return name and strategy
     */
    @Override
        public String toString() {
        return ("Customer's name: " + name + ". They are ordering " + strategy);
    }

    /**
     *
     * @return hashcode
     */
    @Override
    public int hashCode() {
        return name.hashCode();
    }

    /**
     *
     * @param x compare this instance to another
     * @return boolean
     */
    @Override
    public boolean equals (Object x)
    {
        if(!(x instanceof Customer))
        { return false; }
        else if(x == this)
        { return true; }
        else {
            Customer c= (Customer) x;
            return (this.name.equals(c.name)); }
    }
}

