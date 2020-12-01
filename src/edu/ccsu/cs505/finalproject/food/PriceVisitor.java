package edu.ccsu.cs505.finalproject.food;

public class PriceVisitor implements FoodVisitor {
    private double totalPrice = 0.0;

    @Override
    public void visitFood(Food food) {
        this.totalPrice += food.getCost();
    }

    @Override
    public void visitTopping(Toppings topping) {
        this.totalPrice = this.totalPrice + topping.getCost();
    }

    public String toString(){
       return String.format("The total price is: $%.2f", this.totalPrice);
    }

    public double getTotalPrice(){
        return this.totalPrice;
    }
}
