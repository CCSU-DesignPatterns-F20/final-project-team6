package edu.ccsu.cs505.finalproject.food;

public interface FoodVisitor {
     void visitFood(Food food);
     void visitTopping(Toppings topping);
}
