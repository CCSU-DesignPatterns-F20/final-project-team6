package edu.ccsu.cs505.finalproject.processing;

/**
 * Observer interface is part of the observer design pattern. The subject(food) will call update when
 * the food is ready to serve
 */
public interface Observer {

    /**
     * method to update observers
     * @param s message of the update
     */
    public void update(Enum s);
}
