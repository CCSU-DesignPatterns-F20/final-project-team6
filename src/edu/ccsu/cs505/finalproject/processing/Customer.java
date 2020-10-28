package edu.ccsu.cs505.finalproject.processing;
import java.util.Scanner;

public class Customer {

    String name="";
    int strategy;
    public Customer(String firstName, int s){
        name=firstName;
        strategy=s;
    }


    public void orderFood() {


        if(strategy ==1){
            InPerson ip = new InPerson();
            ip.orderFood();
        }else{
            ByPhone bp = new ByPhone();
            bp.orderFood();
        }
    }
}

class test3{

    public static void main(String[] args){

    }
}