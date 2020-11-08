package edu.ccsu.cs505.finalproject.food;

public class Pepperoni extends Food {

    public Pepperoni() {
        this.cost = .50;
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
