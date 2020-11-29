package edu.ccsu.cs505.finalproject.food;

/**
 * abstract class for all of the pizza and grinder toppings
 */
public abstract class Toppings {
    protected Double cost;

    public abstract Object clone();


    /**
     *
     * @return name of class
     */
    public String toString() {
        return getClass().getSimpleName();
    }

    /**
     *
     * @return hash based on cost of topping
     */
    public int hashCode()
    {
        Double h=this.cost*31;
        int hc = (int)Math.round(h);
        return hc;
    }

    /**
     *
     * @param x object to compare
     * @return boolean if the objects equal
     */
    public boolean equals (Object x)
    {
        if(!(x instanceof Toppings))
        {
            return false;
        }

        if( !this.getClass().toString().equalsIgnoreCase(x.getClass().toString()) ){
            return false;
        }

        else if(x == this)
        {
            return true;
        }
        else
        {
            Toppings t = (Toppings) x;
            return (this.cost.equals(t.cost) && this.toString().equals(t.toString()));
        }
    }
}
