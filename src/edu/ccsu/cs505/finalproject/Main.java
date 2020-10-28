package edu.ccsu.cs505.finalproject;

import edu.ccsu.cs505.finalproject.processing.ByPhone;
import edu.ccsu.cs505.finalproject.processing.Customer;
import edu.ccsu.cs505.finalproject.processing.InPerson;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        find out customer's name
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, what is your name?");
        String name = scanner.nextLine();

        System.out.println("How will you be ordering today? \n Type 1 for in person. \n Type 2 for by phone.");
        int selection = scanner.nextInt();


        Customer customer= new Customer(name, selection);
        customer.orderFood();
    }
}
