package edu.ccsu.cs505.finalproject.processing;
import edu.ccsu.cs505.finalproject.food.Food;
import edu.ccsu.cs505.finalproject.food.FreshFoodFactory;
import edu.ccsu.cs505.finalproject.food.MealFactory;

import java.util.Scanner;


/**
 * Cashier will handle taking the order from the customer with the processOrder method.
 * Within processOrder, when the order has been selected, the processTransaction method will be
 * called, which will interact with the singleton cash register. Once that is completed,
 * sendToChef will be called, which creates a chef object before sending the chef the food
 * order
 */
public class Cashier {

    Food foodPick;
    MealFactory foodFactory;

    /**
     * cashier takes order from customer, assigns to variables, sends to cash register then to the chef
     */
    public void processOrder() throws Exception {
        System.out.println("Which number would you like to order?");
        Scanner scanner = new Scanner(System.in);
        MealFactory foodFactory = new FreshFoodFactory();

        int pick = scanner.nextInt();
        if (pick == 1) {
            foodPick = foodFactory.makeFood("pizza");
        }else {
            foodPick = foodFactory.makeFood("grinder");
        }
            System.out.println("Which topping would you like on your "+ foodPick +"? Enter one at a time.Type q to finish");
            String topping;
            while (true) {
                topping = scanner.nextLine();
                if (topping.equals("q")) {
                    break;
                }
                if(!topping.isEmpty())
                {
                    foodPick.addTopping(topping);
                }
            }
        System.out.println("So you'll have a " + foodPick + "? Let me enter that into the cash register");
//        send to cashregister
        // TODO: send the item price to cash register
        CashRegister cashRegister = CashRegister.getInstance();
        cashRegister.updateBalance(0.0); // ** no item price yet

        System.out.println("Sending to the chef now");
        this.sendToChef();
    }

    /**
     * private class to create chef and send the order to cook
     */
        private void sendToChef(){
            Chef chef=new Chef("Bobby Flay");
            try {
                chef.getOrder(foodPick);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }

    /**
     * private class to process transaction in the cash register
     */
    private void processTransaction(){
//        send to cash register
        CashRegister cashRegister = CashRegister.getInstance();
    }

    /**
     *
     * @return the food item and toppings selected
     */
    @Override
    public String toString() {
        return ("Food picked " + foodPick);
    }

    /**
     *
     * @return hashcode based on adding the hashcode of both the food item and toppings
     */
    @Override
    public int hashCode() {
        return foodPick.hashCode() + foodPick.getToppings().hashCode();
    }

    /**
     *
     * @param x
     * @return find out if one object equals this object based on food item and toppings
     */
    public boolean equals (Object x)
    {
        if(!(x instanceof Cashier))
        { return false; }
        else if(x == this)
        { return true; }
        else {
            Cashier c= (Cashier) x;
            return (this.foodPick.equals(c.foodPick) && this.foodPick.getToppings().equals(((Cashier) x).foodPick.getToppings())); }
    }
}
