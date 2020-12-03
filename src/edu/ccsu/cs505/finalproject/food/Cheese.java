package edu.ccsu.cs505.finalproject.food;

/**
 * Cheese is a topping that can be put on a Grinder for an extra cost
 */
public class Cheese extends Toppings{

    public Cheese() {
        this.cost = .50;
    }

    /**
     * @return new instance
     */
     @Override
    public Object clone() {
        return new Cheese();
    }
}