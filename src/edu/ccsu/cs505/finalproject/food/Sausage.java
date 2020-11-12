package edu.ccsu.cs505.finalproject.food;

public class Sausage extends Toppings {

    public Sausage() {
        this.cost = .50;
    }


    @Override
    public String toString() {
        return "Sausage";
    }


    @Override
    public Object clone(boolean b) {
        return new Sausage();
    }


}
