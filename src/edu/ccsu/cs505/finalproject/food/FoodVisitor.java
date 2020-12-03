package edu.ccsu.cs505.finalproject.food;

/**
 * Interface FoodVisitor
 * Part of Visitor Pattern
 * Implemented by class PriceVisitor
 * Gives the ability to the visitor to visit Food and Toppings.
 */
public interface FoodVisitor {

     /**
      * void visitFood, method to visit food of type Food.
      * @param food of type Food, the food that will be visited by the visitor.
      */
     void visitFood(Food food);

     /**
      * void visitTopping, method to visit topping of type Toppings.
      * @param topping of type Toppings, the topping that will be visited by the visitor.
      */
     void visitTopping(Toppings topping);
}
