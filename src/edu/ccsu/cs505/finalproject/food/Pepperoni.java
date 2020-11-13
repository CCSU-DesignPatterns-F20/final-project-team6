package edu.ccsu.cs505.finalproject.food;

/**
 * Pepperoni is a topping that can be put on a Grinder. Will be part of the composite and complex builder
 * patterns in sprint 3
 */
public class Pepperoni extends Toppings {

    public Pepperoni() {
        this.cost = .50;
    }

    /**
     *
     * @param b
     * @return new instance of class
     */
    @Override
    public Object clone(boolean b) {
        return new Pepperoni();
    }
}

class test6{
    public static void main (String[] args){
        Pepperoni p=new Pepperoni();
        System.out.println(p.cost);
    }
}
