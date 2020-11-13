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
     * @param b
     * @return new instance of Lettuce
     */
    @Override
    public Object clone(boolean b) {
        return new Lettuce();
    }

}
class test333 {

    public static void main(String[] args){
        Lettuce L = new Lettuce();
        Toppings L2 = new Turkey();
        System.out.println(L.hashCode());
        System.out.println(L.toString());
        System.out.println(L.equals(L2));
    }
}