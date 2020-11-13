package edu.ccsu.cs505.finalproject.food;

public class Ham extends Toppings {

    public Ham() {
        this.cost = .50;
    }


    @Override
    public String toString() {
        return "Ham";
    }


    @Override
    public Object clone() {
        return new Ham();
    }


}