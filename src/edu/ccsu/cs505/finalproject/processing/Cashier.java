package edu.ccsu.cs505.finalproject.processing;

import edu.ccsu.cs505.finalproject.food.*;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * Cashier will handle taking the order from the customer with the processOrder method.
 * Within processOrder, when the order has been selected, the processTransaction method will be
 * called, which will interact with the singleton cash register. Once that is completed,
 * sendToChef will be called, which creates a chef object before sending the chef the food
 * order
 */
public class Cashier {

    private Food foodPick;

    /**
     * cashier takes order from customer, assigns to variables, sends to cash register then to the chef
     * TODO: handle index out of bounds errors
     */
    public void processOrder() throws Exception {
        System.out.println("Which number would you like to order?");
        Scanner scanner = new Scanner(System.in);

        Menu<Food> menu = new Menu.Builder().Build();

        int pick = scanner.nextInt();
        while (pick < 1 || pick > menu.getMenuSize()){
            System.out.println("Incorrect selection, try again");
            menu.printItems();
            pick = scanner.nextInt();
        }
        // ** get empty food item to put toppings on
        foodPick =  menu.getItem(pick -1).clone();

        if(foodPick.isConfigurable())
        {
            // ** start with no toppings
            foodPick.setToppings(new ArrayList<Toppings>());

            System.out.println("Which topping would you like on your "+ foodPick +"? Enter one at a time.Type 0 to finish");

            Food menuItem = menu.getItem(pick - 1);
            // ** print available toppings
            menuItem.printToppings();

            int intToppingIndex;
            while (true) {
                intToppingIndex = scanner.nextInt();
                if (intToppingIndex == 0) {
                    break;
                }else if(intToppingIndex > 0 && intToppingIndex <= menuItem.getToppings().size())
                {
                    Toppings topping = (Toppings) menuItem.getToppings().get(--intToppingIndex).clone();
                    foodPick.addTopping( topping );
                }else{
                    System.out.println("Not a topping, try again");
                }
            }
        }

        // add visitor price here to add price of pizza and toppings

        PriceVisitor visitor = new PriceVisitor();
        foodPick.setIsConfigurable( false ); // ** to have the price calculated correctly, as price visitor only visits toppings of already configured Food items
        foodPick.accept(visitor);

        System.out.printf("So you'll have a %s with %s? That will be %s$%.2f%s. Let me enter that into the cash register.\n", foodPick.name(), foodPick.getToppings(), Codes.ANSI_GREEN, visitor.getTotalPrice(), Codes.ANSI_RESET);
        Thread.sleep(3000);

        // ** send the item price to cash register
        if(processTransaction(visitor.getTotalPrice()))
        {
            System.out.println("Sending to the chef now");
            Thread.sleep(3000);
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
    private void sendToChef() {
        Chef chef = new Chef("Bobby Flay");

        // attach chef observer to food
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
