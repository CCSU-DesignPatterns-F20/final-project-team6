package edu.ccsu.cs505.finalproject.food;

public class Peppers extends Toppings {

    public Peppers() {
        this.cost = .50;
    }


    @Override
    public String toString() {
        return "Peppers";
    }


    @Override
    public Object clone(boolean b) {
        return new Peppers();
    }

}
