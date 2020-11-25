package edu.ccsu.cs505.finalproject.food;

public class PriceVisitor implements FoodVisitor {
    private double totalPrice = 0.0;

    @Override
    public void visitPizza(Pizza pizza) {
        this.totalPrice = this.totalPrice + pizza.getCost();
    }

    @Override
    public void visitGrinder(Grinder grinder) {
        this.totalPrice = this.totalPrice + grinder.getCost();
    }

    @Override
    public void visitTopping(Toppings topping) {
        this.totalPrice = this.totalPrice + topping.getCost();
    }
}
