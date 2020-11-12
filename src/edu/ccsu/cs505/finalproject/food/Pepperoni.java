package edu.ccsu.cs505.finalproject.food;

public class Pepperoni extends Toppings {

    public Pepperoni() {
        this.cost = .50;
    }


    @Override
    public String toString() {
        return "Pepperoni";
    }


    @Override
    public Object clone(boolean b) {
        return new Pepperoni();
    }
}

class test6{
    public static void main (String[] args){
        Pepperoni p=new Pepperoni();
        System.out.println(p.cost);
    }
}
