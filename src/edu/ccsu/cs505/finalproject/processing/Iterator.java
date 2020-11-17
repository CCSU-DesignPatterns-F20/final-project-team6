package edu.ccsu.cs505.finalproject.processing;

public interface Iterator<T> {
    public T next();
    public Boolean hasNext();
    public void remove();

}
