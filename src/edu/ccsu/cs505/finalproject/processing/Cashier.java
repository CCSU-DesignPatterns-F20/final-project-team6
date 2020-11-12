package edu.ccsu.cs505.finalproject.processing;

import edu.ccsu.cs505.finalproject.food.Food;
import edu.ccsu.cs505.finalproject.food.FoodFactory;
import edu.ccsu.cs505.finalproject.food.Toppings;

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
    FoodFactory foodFactory;

    /**
     * cashier takes order from customer, assigns to variables, sends to cash register then to the chef
     * TODO: handle index out of bounds errors
     */
    public void processOrder() throws Exception {
        System.out.println("Which number would you like to order?");
        Scanner scanner = new Scanner(System.in);

        Menu<Food> menu = new Menu.Builder().Build();

        int pick = scanner.nextInt();

        // ** get empty food item to put toppings on
        foodPick =  menu.items.get(pick -1).clone(false);
        System.out.println("Which topping would you like on your "+ foodPick +"? Enter one at a time.Type 0 to finish");

        Food menuItem = menu.items.get(pick - 1);
        // ** print available toppings
        menuItem.printToppings();

        int intToppingIndex;
        while (true) {
            intToppingIndex = scanner.nextInt();
            if (intToppingIndex == 0) {
                break;
            }
            if(intToppingIndex > 0)
            {
                Toppings topping = (Toppings) menuItem.getToppings().get(--intToppingIndex).clone(false);
                foodPick.addTopping( topping );
            }
        }
        System.out.println("So you'll have a " + foodPick + "? Let me enter that into the cash register");
//        send to cashregister
        // TODO: send the item price to cash register
        if(processTransaction(foodPick.getCost())) // ** no item price yet
        {
            System.out.println("Sending to the chef now");
            this.sendToChef();
        }
        else
        {
            System.out.println("Transaction failed, please try again...");
        }
    }

    /**
     * private method to create chef and send the order to cook
     */
        private void sendToChef(){
            Chef chef=new Chef("Bobby Flay");

//            attach chef observer to food

            foodPick.attach(chef);
            try {
                chef.getOrder(foodPick);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }

    /**
     * private class to process transaction in the cash register
     * @param transactionAmount to adjust cash register balance
     * @return
     */
    private boolean processTransaction(Double transactionAmount){
//        send to cash register
        CashRegister cashRegister = CashRegister.getInstance();

        if(!cashRegister.isPowered())
        {
            cashRegister.powerPress();
        }
        cashRegister.unlock("1234");

        cashRegister.openDrawer();

        boolean transactionSuccess  = cashRegister.depositCash(transactionAmount);

        cashRegister.lock();

        return transactionSuccess;
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
