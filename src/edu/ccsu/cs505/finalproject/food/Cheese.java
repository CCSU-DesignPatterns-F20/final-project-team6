package edu.ccsu.cs505.finalproject.food;

public class Cheese extends Toppings{

    public Cheese() {
        this.cost = .50;
    }


    @Override
    public String toString() {
        return "Lettuce";
    }

     @Override
    public Object clone(boolean b) {
        return new Cheese();
    }
}