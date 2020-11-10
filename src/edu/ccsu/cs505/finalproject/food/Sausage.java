package edu.ccsu.cs505.finalproject.food;

public class Sausage extends Food {

    public Sausage() {
        this.cost = .50;
    }

    @Override
    public String name() {
        return "Sausage";
    }

    @Override
    public Food clone(Boolean deep) {
        return new Sausage();
    }

    @Override
    protected void setup(){}
    @Override
    protected void cook(){}
    @Override
    protected void slice(){}
}
