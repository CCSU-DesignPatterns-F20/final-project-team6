package edu.ccsu.cs505.finalproject.food;

public class Mushroom extends Toppings {

    public Mushroom() {
        this.cost = .50;
    }


    @Override
    public String toString() {
        return "Mushroom";
    }

    @Override
    public Object clone(boolean b) {
        return new Mushroom();
    }
}