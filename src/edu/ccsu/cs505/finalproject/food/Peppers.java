package edu.ccsu.cs505.finalproject.food;

public class Peppers extends Food {

    public Peppers() {
        this.cost = .50;
    }

    @Override
    public Food clone(Boolean deep) {
        return new Peppers();
    }
    @Override
    protected void setup(){}
    @Override
    protected void cook(){}
    @Override
    protected void slice(){}
}
