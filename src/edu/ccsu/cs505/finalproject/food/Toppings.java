package edu.ccsu.cs505.finalproject.food;

/**
 * abstract class for all of the pizza and grinder toppings
 */
public abstract class Toppings {
    protected Double cost;

    public abstract Object clone();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Toppings toppings = (Toppings) o;
        return cost.equals(toppings.cost);
    }

    @Override
    public int hashCode() {
        return cost.hashCode();
    }
}
