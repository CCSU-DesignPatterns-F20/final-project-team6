package edu.ccsu.cs505.finalproject.processing;

/**
 * Observer interface is part of the observer design pattern. The subject(food) will call update when
 * the food is ready to serve
 */
public interface Observer {

    public void update(String s);
}
