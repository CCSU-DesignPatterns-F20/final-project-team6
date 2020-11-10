package edu.ccsu.cs505.finalproject.food;

public class Cheese extends Food {

    public Cheese() {
        this.cost = .50;
    }

    @Override
    public String name() {
        return "Cheese";
    }

    @Override
    public Food clone(Boolean deep) {
        return new Cheese();
    }

    @Override
    protected void setup(){}
    @Override
    protected void cook(){}
    @Override
    protected void slice(){}
}