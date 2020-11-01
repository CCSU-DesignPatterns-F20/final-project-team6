package edu.ccsu.cs505.finalproject.processing;


/**
 * OrderingStrategy is a interface class that is part of the strategy design pattern. It allows for a
 * level of abstraction when selecting the concrete strategy of how the client will be ordering
 * food
 */
public interface OrderingStrategy {
    /**
     * Will allow customer to order food by their desired strategy
     * @throws Exception
     */
    public void orderFood() throws Exception;
}
