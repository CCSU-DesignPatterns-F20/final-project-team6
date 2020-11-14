package edu.ccsu.cs505.finalproject.food;

/**
 * Lettuce is a topping that can be put on a Grinder. Will be part of the composite and complex builder
 * patterns in sprint 3
 */
public class Lettuce extends Toppings {

    public Lettuce() {
        this.cost = .50;
    }

    /**
     *
     * @return new instance of Lettuce
     */
    @Override
    public Object clone() {
        return new Lettuce();
    }

}
class test333 {

    public static void main(String[] args){
        Lettuce l = new Lettuce();
        Toppings l2 = new Turkey();
        System.out.println(l.hashCode());
        System.out.println(l.toString());
        System.out.println(l.equals(l2));
    }
}