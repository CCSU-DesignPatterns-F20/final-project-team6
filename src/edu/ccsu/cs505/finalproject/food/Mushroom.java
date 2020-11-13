package edu.ccsu.cs505.finalproject.food;

/**
 * Mushroom is a topping that can be put on a Grinder. Will be part of the composite and complex builder
 * patterns in sprint 3
 */
public class Mushroom extends Toppings {

    public Mushroom() {
        this.cost = .50;
    }

    /**
     *
     * @param b
     * @return new instance of class
     */
    @Override
    public Object clone() {
        return new Mushroom();
    }
}