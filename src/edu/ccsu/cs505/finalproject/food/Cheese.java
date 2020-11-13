package edu.ccsu.cs505.finalproject.food;

/**
 * Cheese is a topping that can be put on a Grinder. Will be part of the composite and complex builder
 * patterns in sprint 3
 */
public class Cheese extends Toppings{

    public Cheese() {
        this.cost = .50;
    }

    /**
     *
     * @param b
     * @return new instance
     */
     @Override
    public Object clone() {
        return new Cheese();
    }
}