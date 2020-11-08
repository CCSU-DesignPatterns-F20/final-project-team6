package edu.ccsu.cs505.finalproject;

import edu.ccsu.cs505.finalproject.processing.ByPhone;
import edu.ccsu.cs505.finalproject.processing.Customer;
import edu.ccsu.cs505.finalproject.processing.InPerson;
import edu.ccsu.cs505.finalproject.processing.OrderingStrategy;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        find out customer's name
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, what is your name?");
        String name = scanner.nextLine();

        System.out.println("How will you be ordering today? \n Type 1 for in person. \n Type 2 for by phone.");
        int selection = scanner.nextInt();

        OrderingStrategy strategy;
        if(selection ==1){
             strategy = new InPerson();
        }else{
            strategy = new ByPhone();
        }
        Customer customer= new Customer(name, strategy);

        try{
            customer.orderFood();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
