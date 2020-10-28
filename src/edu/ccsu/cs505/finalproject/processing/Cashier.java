package edu.ccsu.cs505.finalproject.processing;

import edu.ccsu.cs505.finalproject.food.Food;
import edu.ccsu.cs505.finalproject.food.GrinderFactory;
import edu.ccsu.cs505.finalproject.food.MealFactory;
import edu.ccsu.cs505.finalproject.food.PizzaFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cashier {

    Food foodPick;
    List<String> toppingsPick = new ArrayList<String>();
    MealFactory foodFactory;

    /**
     * cashier takes order from customer, sends to cash register then to the chef
     */
    public void processOrder() {
        System.out.println("Which number would you like to order?");
        Scanner scanner = new Scanner(System.in);

        int pick = scanner.nextInt();
//        String topping = scanner.hasNext()
        boolean keepGoing = true;
        if (pick == 1) {
            foodFactory = new PizzaFactory();
            foodPick = foodFactory.makeFood();

            System.out.println("Which topping would you like on your pizza? Enter one at a time.Type q to finish");
            String topping = scanner.nextLine();
            while (keepGoing) {
                toppingsPick.add(topping);
                topping = scanner.nextLine();
                if (topping.equals("q")) {
                    keepGoing = false;
                }
            }
        } else {
            foodFactory = new GrinderFactory();
            foodPick = foodFactory.makeFood();
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
        System.out.println("So you'll have a " + foodPick + " with " + toppingsPick+ "? Let me enter that into the cash register");
//        send to cashregister
        System.out.println("Sending to the chef now");
        this.sendToChef();
    }
        private void sendToChef(){
            Chef chef=new Chef("Bobby Flay");
            try {
                chef.getOrder(foodPick, toppingsPick);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
    private void processTransaction(){
//        send to cash register
    }

    @Override
    public String toString() {
        return ("Food picked " + foodPick+ " with toppings " + toppingsPick);
    }

}
//class test2{
//    main String void
//}