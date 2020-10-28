package edu.ccsu.cs505.finalproject.processing;
import java.util.Scanner;

public class Customer {

    String name="";
    OrderingStrategy strategy;

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
    public void orderFood() { strategy.orderFood();}

    /**
     *
     * @return name and strategy
     */
    @Override
        public String toString() {
        return ("Customer's name: " + name + ". They are is ordering " + strategy);
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

class test{
    public static void main(String []args){
        Customer customer=new Customer("Kelly", new InPerson());
        Customer customer2=new Customer("Kelly", new InPerson());
        System.out.println(customer.toString());
        System.out.println(customer.hashCode());
        System.out.println(customer2.toString());
        System.out.println(customer2.hashCode());
        System.out.println(customer2.equals(customer));
    }
}
