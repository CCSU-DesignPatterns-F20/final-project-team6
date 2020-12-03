package edu.ccsu.cs505.finalproject;

import edu.ccsu.cs505.finalproject.processing.ByPhone;
import edu.ccsu.cs505.finalproject.processing.Customer;
import edu.ccsu.cs505.finalproject.processing.InPerson;
import edu.ccsu.cs505.finalproject.processing.OrderingStrategy;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        first find out the way the customer is ordering

        Scanner sc1= new Scanner(System.in);
        System.out.println("Hello! Thank you for choosing our restaurant. How will you be ordering today?");
        System.out.println("Type 1 for in person.\nType 2 for by phone.");
        int selection = sc1.nextInt();

        while (selection < 1 || selection > 2){
            System.out.println("Incorrect selection, try again");
            selection = sc1.nextInt();
        }
        OrderingStrategy orderingStrategy;
        if(selection ==1){
            orderingStrategy = new InPerson();
        }else{
            orderingStrategy = new ByPhone();
        }


//      now set up a customer account
        Scanner scanner = new Scanner(System.in);
        System.out.println("Before you order, let's set you up with a customer account. What is your first name?");
        String firstName = scanner.nextLine();
        System.out.println("What is your last name?");
        String lastName = scanner.nextLine();
        System.out.println("What is your phone number?");
        String phone = scanner.nextLine();
        System.out.println("What is your email address?");
        String email = scanner.nextLine();
        System.out.println("Lastly, what is your home address?");
        String home = scanner.nextLine();

        Customer customer = new Customer.CustomerBuilder(firstName, lastName, orderingStrategy)
                .setAddress(home)
                .setPhoneNumber(phone)
                .setEmail(email).buildCustomer();
        System.out.println("Here is the information you have for you - "+customer.toString());

        try{
            Thread.sleep(3000);
            customer.orderFood();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
