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
        String topping = null;
        if(pick==1){
            foodPick="Pizza";
            System.out.println("Which topping would you like on your pizza? Enter one at a time.Type end to finish");
            while(topping != "end"){
                toppingsPick.add(topping);
            }
            foodPick="Grinder";
            System.out.println("Which topping would you like on your grinder? Enter one at a time. Type end to finish");
            while(topping != "end"){
                toppingsPick.add(topping);
            }
        }
    }
}
