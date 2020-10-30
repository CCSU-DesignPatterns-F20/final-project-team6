package edu.ccsu.cs505.finalproject.processing;

import edu.ccsu.cs505.finalproject.food.Food;
import edu.ccsu.cs505.finalproject.food.FreshFoodFactory;
import edu.ccsu.cs505.finalproject.food.MealFactory;
import edu.ccsu.cs505.finalproject.food.FrozenFoodFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cashier {

    Food foodPick;
    List<String> toppingsPick = new ArrayList<String>();
    MealFactory foodFactory;

    /**
     * cashier takes order from customer, assigns to variables, sends to cash register then to the chef
     */
    public void processOrder() throws Exception {
        System.out.println("Which number would you like to order?");
        Scanner scanner = new Scanner(System.in);
        MealFactory foodFactory = new FreshFoodFactory();

        int pick = scanner.nextInt();
//        String topping = scanner.hasNext()
        boolean keepGoing = true;
        if (pick == 1) {
            foodPick = foodFactory.makeFood("pizza");
        }else {
            foodPick = foodFactory.makeFood("grinder");
        }
            System.out.println("Which topping would you like on your "+ foodPick +"? Enter one at a time.Type q to finish");
            String topping = scanner.nextLine();
            while (keepGoing) {
                toppingsPick.add(topping);
                topping = scanner.nextLine();
                if (topping.equals("q")) {
                    keepGoing = false;
                }
            }
        System.out.println("So you'll have a " + foodPick + " with " + toppingsPick+ "? Let me enter that into the cash register");
//        send to cashregister
        System.out.println("Sending to the chef now");
        this.sendToChef();
    }

    /**
     * private class to create chef and send the order to cook
     */
        private void sendToChef(){
            Chef chef=new Chef("Bobby Flay");
            try {
                chef.getOrder(foodPick, toppingsPick);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }

    /**
     * private class to process transaction in the cash register
     */
    private void processTransaction(){
//        send to cash register
    }

    /**
     *
     * @return the food item and toppings selected
     */
    @Override
    public String toString() {
        return ("Food picked " + foodPick+ " with toppings " + toppingsPick);
    }

    /**
     *
     * @return hashcode based on adding the hashcode of both the food item and toppings
     */
    @Override
    public int hashCode() {
        return foodPick.hashCode() + toppingsPick.hashCode();
    }

    /**
     *
     * @param x
     * @return find out if one object equals this object based on food item and toppings
     */
    public boolean equals (Object x)
    {
        if(!(x instanceof Customer))
        { return false; }
        else if(x == this)
        { return true; }
        else {
            Cashier c= (Cashier) x;
            return (this.foodPick.equals(c.foodPick) && this.toppingsPick.equals(c.toppingsPick)); }
    }
}
