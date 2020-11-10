package edu.ccsu.cs505.finalproject.food;

public class Mushroom extends Food {

    public Mushroom() {
        this.cost = .50;
    }

    @Override
    public Food clone(Boolean deep) {
        return new Mushroom();
    }

    @Override
    protected void setup(){}
    @Override
    protected void cook(){}
    @Override
    protected void slice(){}
}