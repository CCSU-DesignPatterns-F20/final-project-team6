package edu.ccsu.cs505.finalproject.processing;
import java.util.Scanner;

public class Customer {

    String name="";
    OrderingStrategy strategy;
    public Customer(String firstName, OrderingStrategy s){
        name=firstName;
        strategy=s;
    }


    public void orderFood() {

    strategy.orderFood();

    }
}

class test3{

    public static void main(String[] args){

    }
}