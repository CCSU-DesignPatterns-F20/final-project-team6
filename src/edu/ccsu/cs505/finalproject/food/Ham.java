package edu.ccsu.cs505.finalproject.food;
/**
 * Ham is a topping that can be put on a Grinder. Will be part of the composite and complex builder
 * patterns in sprint 3
 */
public class Ham extends Toppings {

    public Ham() {
        this.cost = .50;
    }

    /**
     *
     * @param b
     * @return new instance of class
     */
    @Override
    public Object clone() {
        return new Ham();
    }


}