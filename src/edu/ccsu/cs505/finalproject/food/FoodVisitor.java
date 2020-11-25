package edu.ccsu.cs505.finalproject.food;

public interface FoodVisitor {
     void visitPizza(Pizza pizza);
     void visitGrinder(Grinder grinder);
     void visitTopping(Toppings topping);
}
