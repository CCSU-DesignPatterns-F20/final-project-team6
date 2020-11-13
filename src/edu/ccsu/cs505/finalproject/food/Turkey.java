package edu.ccsu.cs505.finalproject.food;

public class Turkey extends Toppings {

    public Turkey() {
        this.cost = .50;
    }

    @Override
    public String toString() {
        return "Turkey";
    }

    @Override
    public Object clone() {
        return new Turkey();
    }

}