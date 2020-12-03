package edu.ccsu.cs505.finalproject.processing;

/**
 * Singleton design pattern on CashRegister
 */
public class CashRegister {
//    only instance
    private static CashRegister instance = null;
    private Double balance = 0.0;
    private CashRegisterState currentState = new CashRegisterStateOff();

    private boolean power = false;
    private CashRegisterDrawerState drawerState = CashRegisterDrawerState.CLOSED;

    @Override
    public boolean equals(Object o) {
        if(o instanceof CashRegister){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "CashRegister{" +
          "balance=" + balance +
          ", currentState=" + currentState +
          ", power=" + power +
          ", drawerState=" + drawerState +
          '}';
    }

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
        if (instance == null){
            instance = new CashRegister();}
        return instance;
    }

    /**
     * @param adjustment updates current cash register balance
     * @return true if there is enough funds, false otherwise
     */
    private boolean updateBalance(Double adjustment)
    {
        // TODO: check if we have enough funds
        this.balance += adjustment;
        System.out.printf("Added $%.2f to cash register.\n", adjustment);
        return true;
    }

    /**
     * @param balance sets cash register balance to specified amount
     */
    private void setBalance(Double balance)
    {
        this.balance = balance;
    }

    /**
     * @return current balance
     */
    public Double getBalance()
    {
        return this.balance;
    }

    /**
     * @return true if powered, false otherwise
     */
    public boolean isPowered(){
        return this.power;
    }

    //region State Pattern helpers
    void setPowerOn(boolean power) {
        this.power = power;
        if (this.power) {
            System.out.println("Cash Register is On");
        }else {
            System.out.println("Cash Register is Off");
        }
    }

    /**
     * @param drawerState state to set the drawer to, OPEN or CLOSED
     */
    void operateDrawer(CashRegisterDrawerState drawerState) {
        this.drawerState = drawerState;
    }

    /**
     * Opens cash register drawer, only when cash register is on and unlocked
     */
    void openDrawer(){
        currentState.openDrawer(this);
    }

    void closeDrawer(){
        currentState.closeDrawer(this);
    }

    /**
     *  Acts upon power button press
     */
    void powerPress(){
        currentState.powerPress(this);
    };

    /**
     * Locks the register so it is inoperable by unauthorized people
     */
    void lock(){
        currentState.lock(this);
    };

    /**
     * @param code to unlock the register
     * @return true if code was accepted and unlocking was successful, false it was invalid
     */
    boolean unlock(String code){
        return currentState.unlock(code, this );
    };

    /**
     * @param amount to deposit
     * @return
     */
    boolean depositCash(Double amount){
        if( currentState.allowDeposit(amount, this ) ) {
            if( this.drawerState == CashRegisterDrawerState.OPEN){
                return this.updateBalance(amount);
            }
            else
            {
                System.out.println("Cash Register is closed, open it first");
                return false;
            }
        }
        return false;
    }

    /**
     * @param amount to return change to customer
     * @return true if successfully returned cash to customer, false if there were cash register issues that prevented it
     */
    boolean getChange(Double amount){
        if( currentState.allowGetChange(amount, this ) ) {
            if( this.drawerState == CashRegisterDrawerState.OPEN){
                return this.updateBalance(-amount);
            }
            else
            {
                System.out.println("Cash Register is closed, open it first");
                return false;
            }
        }
        return false;
    };

    /**
     * @param newState state to switch to
     */
    void setCashRegisterState(CashRegisterState newState){
        this.currentState = newState;
    }
    //endregion
}
