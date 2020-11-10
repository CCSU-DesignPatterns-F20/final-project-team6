package edu.ccsu.cs505.finalproject.processing;

/**
 * This Customer class represents the customer in the restaurant simulator. It is the "client"
 * part of the strategy design pattern. Customer is given two attributes, a name
 * and an ordering strategy.
 *
 * orderfood method will start the ordering process by sending the customer over to the strategy
 * the customer has selected.
 */
public class Customer {

    private String firstName;
    private String lastName;
    private OrderingStrategy orderingStrategy;
    private String address;
    private String phoneNumber;
    private String email;


    private Customer(Customer.CustomerBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.orderingStrategy= builder.orderingStrategy;
        this.address = builder.address;
        this.phoneNumber = builder.phoneNumber;
        this.email = builder.email;

    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public OrderingStrategy getOrderingStrategy() {
        return this.orderingStrategy;
    }

    public String getAddress() {
        return this.address;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getEmail() {
        return this.email;
    }

    /**
     * order food based on strategy selected
     */
    public void orderFood() throws Exception { orderingStrategy.orderFood(); }

    /**
     *
     * @return name and strategy
     */
    @Override
    public String toString() {


        StringBuilder stringBuilder = new StringBuilder("Customer("+firstName+" "+lastName +") with:");
        if (address !=null) {
            stringBuilder.append(" address="+address);
        }
        if (phoneNumber != null) {
            stringBuilder.append(", phoneNumber="+phoneNumber);
        }
        if (email!=null) {
            stringBuilder.append(", email="+email);

        }
        return stringBuilder.toString()+" is ordering " + orderingStrategy.toString();

    }

    /**
     *
     * @return hashcode
     */
    @Override
    public int hashCode() { return firstName.hashCode() + lastName.hashCode(); }

    /**
     *
     * @param x compare this instance to another
     * @return boolean
     */
    @Override
    public boolean equals (Object x)
    {
        if(!(x instanceof Customer))
        { return false; }
        else if(x == this)
        { return true; }
        else {
            Customer c= (Customer) x;
            return (this.firstName.equals(c.firstName)&&this.lastName.equals(c.lastName)); }
    }

    public static class CustomerBuilder {

        private String firstName = null;
        private String lastName = null;
        private OrderingStrategy orderingStrategy = null;
        private String address = null;
        private String phoneNumber = null;
        private String email = null;


        public CustomerBuilder(String firstName, String lastName, OrderingStrategy orderingStrategy) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.orderingStrategy = orderingStrategy;
        }

        public Customer buildCustomer(){
            if (!builderComplete()){
                throw new RuntimeException("Illegal person state");
            }
            return new Customer(this);
        }

        public boolean builderComplete(){
            if ((firstName!=null)&&(lastName!=null)&&(orderingStrategy!=null)) {
                if (address!=null) {
                    return true;
                }else if(phoneNumber!=null) {
                    return true;
                }else if(email!=null) {
                    return true;
                }
            }
            return false;
        }

        /**
         * @param address the Customer's address to set
         */
        public Customer.CustomerBuilder setAddress (String address) {
            this.address = address;
            return this;
        }
        /**
         * @param phoneNumber the Customer's phone number to set
         */
        public Customer.CustomerBuilder setPhoneNumber (String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        /**
         * @param email the Customer's email to set
         */
        public Customer.CustomerBuilder setEmail (String email) {
            this.email = email;
            return this;
        }
    }
}
