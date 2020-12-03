package edu.ccsu.cs505.finalproject.food;

/**
 * Interface FoodVisitable
 * Part of Visitor Pattern
 * Implemented by class Food and class Topping
 * Gives the ability to be visited by FoodVisitor
 */
public interface FoodVisitable {
    /**
     * void accept, makes the FoodVisitor visitor acceptable to the class the provides the implementation.
     * @param visitor the visitor of type FoodVisitor that needs to be accepted in the class
     */
    void accept(FoodVisitor visitor);
}
