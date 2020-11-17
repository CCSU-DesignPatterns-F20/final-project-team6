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
        System.out.println("Hello, what is your first name?");
        String firstName = scanner.nextLine();
        System.out.println("And your last name?");
        String lastName = scanner.nextLine();

        System.out.println("How will you be ordering today? \n Type 1 for in person. \n Type 2 for by phone.");
        int selection = scanner.nextInt();

        while (selection < 1 || selection > 2){
            System.out.println("Incorrect selection, try again");
            selection = scanner.nextInt();
        }
        OrderingStrategy orderingStrategy;
        if(selection ==1){
             orderingStrategy = new InPerson();
        }else{
            orderingStrategy = new ByPhone();
        }

        Customer customer = new Customer.CustomerBuilder(firstName, lastName, orderingStrategy)
                .setAddress("Home")
                .setPhoneNumber("012-345-6789")
                .setEmail("email").buildCustomer();
        System.out.println(customer.toString());


        try{
            customer.orderFood();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
