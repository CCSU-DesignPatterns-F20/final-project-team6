package edu.ccsu.cs505.finalproject.food;

/**
 * class PriceVisitor
 * Part of Visitor Pattern
 * Implements FoodVisitor
 * Gives the ability to calculate the total price based on the associated cost of food and toppings.
 */
public class PriceVisitor implements FoodVisitor {

    private double totalPrice = 0.0;

    /**
     * public void visitFood, gets the cost of the food and adds it to the total price.
     * @param food of type Food, the food that will be visited by the visitor to get the cost that will be added to the total price.
     */
    @Override
    public void visitFood(Food food) {
        this.totalPrice += food.getCost();
    }

    /**
     * public void visitTopping, gets the cost of the topping and adds it to the total price.
     * @param topping of type Topping, the topping that will be visited by the visitor to get the cost that will be added to the total price.
     */
    @Override
    public void visitTopping(Toppings topping) {
        this.totalPrice = this.totalPrice + topping.getCost();
    }

    /**
     * Getter
     * public double getTotalPrice, returns the total price.
     * @return double, the total price.
     */
    public double getTotalPrice(){
        return this.totalPrice;
    }

    public String toString(){
        return String.format("The total price is: $%.2f", this.totalPrice);
    }
}
