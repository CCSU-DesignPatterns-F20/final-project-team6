package edu.ccsu.cs505.finalproject.food;

public class Pepperoni extends Food {

    public Pepperoni() {
        this.cost = .50;
    }

    @Override
    public String name() {
        return "Pepperoni";
    }

    @Override
    public Food clone(Boolean deep) {
        return new Pepperoni();
    }

    @Override
    protected void setup(){}
    @Override
    protected void cook(){}
    @Override
    protected void slice(){}
}

class test6{
    public static void main (String[] args){
        Pepperoni p=new Pepperoni();
        System.out.println(p.getCost());
    }
}
