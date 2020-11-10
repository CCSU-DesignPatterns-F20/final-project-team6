package edu.ccsu.cs505.finalproject.food;

public class Ham extends Food {

    public Ham() {
        this.cost = .50;
    }

    @Override
    public String name() {
        return "Ham";
    }

    @Override
    public Food clone(Boolean deep) {
        return new Ham();
    }

    @Override
    protected void setup(){}
    @Override
    protected void cook(){}
    @Override
    protected void slice(){}
}