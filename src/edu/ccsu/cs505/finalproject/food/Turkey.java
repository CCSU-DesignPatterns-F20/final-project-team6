package edu.ccsu.cs505.finalproject.food;

public class Turkey extends Food {

    public Turkey() {
        this.cost = .50;
    }
    @Override
    public Food clone(Boolean deep) {
        return new Turkey();
    }
    @Override
    protected void setup(){}
    @Override
    protected void cook(){}
    @Override
    protected void slice(){}
}