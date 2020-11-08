package edu.ccsu.cs505.finalproject.processing;

/**
 * Singleton design pattern on CashRegister
 */
public class CashRegister {
//    only instance
    private static CashRegister CR = null;
    private Double balance = 0.0;

    /**
     * private constructor to prevent more than one instance
     */
    private CashRegister(){
//        add some fields
    }

    /**
     * find out if instance has been created, if not, create it.
     * @return the one instance
     */
    public static CashRegister getInstance(){
        if (CR == null){
            CR = new CashRegister();}
        return CR;
    }

    /**
     * @param adjustment updates current cash register balance
     */
    public void updateBalance(Double adjustment)
    {
        this.balance += adjustment;
    }

    /**
     * @param balance sets cash register balance to specified amount
     */
    public void setBalance(Double balance)
    {
        this.balance = balance;
    }
}
