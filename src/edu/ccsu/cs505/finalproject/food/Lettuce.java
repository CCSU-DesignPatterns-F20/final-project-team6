package edu.ccsu.cs505.finalproject.food;

public class Lettuce extends Food {

    public Lettuce() {
        this.cost = .50;
    }

    @Override
    public String name() {
        return "Lettuce";
    }

    @Override
    public Food clone(Boolean deep) {
        return new Lettuce();
    }

    @Override
    protected void setup(){}
    @Override
    protected void cook(){}
    @Override
    protected void slice(){}
}
