package edu.ccsu.cs505.finalproject.processing;

public class InPerson implements OrderingStrategy {

    /**
     * food selection will be sent to cashier
     */
    @Override
    public void orderFood() {

        System.out.println("Hello thank you for coming to our restaurant. Here are the items we have today");
        Menu.showMenu();
        Cashier cashier=new Cashier();
        cashier.processOrder();
    }

    /**
     *
     * @return class name
     */
    @Override
    public String toString() {
        return this.getClass().getName();
    }

    /**
     *
     * @param x compare object x to this object
     * @return boolean response
     */
    @Override
    public boolean equals (Object x)
    {
        if(x == this) { return true;} else { return false;}
    }

    /**
     *
     * @return hashcode
     */
    @Override
    public int hashCode()
    {
//        will add proper hashcode
        return 0;
    }
}

class test15{
    public static void main(String[] args){
        InPerson ip = new InPerson();
        ip.toString();
    }
        }