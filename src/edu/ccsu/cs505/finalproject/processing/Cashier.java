package edu.ccsu.cs505.finalproject.processing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cashier {

    String foodPick;
    List<String> toppingsPick = new ArrayList<String>();

    public void processOrder() {
        System.out.println("Which number would you like to order?");
        Scanner scanner = new Scanner(System.in);

        int pick = scanner.nextInt();
//        String topping = scanner.hasNext()
        boolean keepGoing = true;
        if (pick == 1) {
            foodPick = "Pizza";
            System.out.println("Which topping would you like on your pizza? Enter one at a time.Type q to finish");
//            boolean user = true;
            String topping = scanner.nextLine();
            while (keepGoing) {
                toppingsPick.add(topping);
                topping = scanner.nextLine();
                if (topping.equals("q")) {
                    keepGoing = false;
                }
            }

            }else{
            foodPick = "Grinder";
            System.out.println("Which topping would you like on your grinder? Enter one at a time.Type q to finish");
            String topping = scanner.nextLine();
            while (keepGoing) {
                toppingsPick.add(topping);
                topping = scanner.nextLine();
                if (topping.equals("q")) {
                    keepGoing = false;
                }


            }
        }
        System.out.println("So you'll have a " + foodPick + " with " + toppingsPick);
//        send to cashregister
//        send to cook
    }
}