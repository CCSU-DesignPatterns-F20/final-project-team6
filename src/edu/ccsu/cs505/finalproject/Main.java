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

        Customer customer= new Customer(name);

        System.out.println("How will you be ordering today? \n Type 1 for in person. \n Type 2 for by phone.");
        int selection = scanner.nextInt();

        if(selection ==1){
            InPerson ip = new InPerson(customer);
            ip.orderFood();
        }else{
            ByPhone bp = new ByPhone(customer);
            bp.orderFood();
        }
    }
}
