package edu.ccsu.cs505.finalproject.processing;

/**
 * This Customer class represents the customer in the restaurant simulator. It is the "client"
 * part of the strategy design pattern.
 *
 * Additionally to that, Customer class is also part of the simple Builder pattern having as nested class CustomerBuilder.
 *
 * A Customer has 3 required attributes when built, which are first name, last name and the way he will be ordering and
 * 3 optional attributes which are home address, phone number and email address.
 */
public class Customer {

    private String firstName;
    private String lastName;
    private OrderingStrategy orderingStrategy;
    private String address;
    private String phoneNumber;
    private String email;

    /**
     * Private Constructor, used by the builder to create an instance of a Customer
     */
    private Customer(Customer.CustomerBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.orderingStrategy= builder.orderingStrategy;
        this.address = builder.address;
        this.phoneNumber = builder.phoneNumber;
        this.email = builder.email;
    }

    /**
     * Getter
     * @return Customer's first name
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Getter
     * @return Customer's last name
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Getter
     * @return Customer's ordering strategy
     */
    public OrderingStrategy getOrderingStrategy() {
        return this.orderingStrategy;
    }

    /**
     * Getter
     * @return Customer's address
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Getter
     * @return Customer's phone number
     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Getter
     * @return Customer's email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * order food based on strategy selected
     */
    public void orderFood() throws Exception { orderingStrategy.orderFood(); }

    /**
     *
     * @return String including all Customer's attributes
     */
    @Override
    public String toString() {


        StringBuilder stringBuilder = new StringBuilder("Customer("+firstName+" "+lastName +") with:");
        if (address !=null) {
            stringBuilder.append(" address=").append(address);
        }
        if (phoneNumber != null) {
            stringBuilder.append(", phoneNumber=").append(phoneNumber);
        }
        if (email!=null) {
            stringBuilder.append(", email=").append(email);

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

    /**
     * Nested static class CustomerBuilder part of the Builder pattern.
     */
    public static class CustomerBuilder {

        private String firstName = null;
        private String lastName = null;
        private OrderingStrategy orderingStrategy = null;
        private String address = null;
        private String phoneNumber = null;
        private String email = null;

        /**
         * Public Constructor, used in order to create an instance of Customer
         *
         * @param firstName Customer's first name required
         * @param lastName Customer's last name required
         * @param orderingStrategy required ordering strategy(aka the way the customer will be ordering)
         */
        public CustomerBuilder(String firstName, String lastName, OrderingStrategy orderingStrategy) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.orderingStrategy = orderingStrategy;
        }


        /**
         * Public buildCustomer, makes sure Customer's attributes are not null by calling builderComplete.
         * If one of the attributes is null it throws RuntimeException, otherwise it creates a new Customer instance.
         *
         * @return new Customer instance
         */
        public Customer buildCustomer(){
            if (!builderComplete()){
                throw new RuntimeException("Illegal person state");
            }
            return new Customer(this);
        }

        /**
         * Public builderComplete, makes sure the Customer's attributes are not null
         *
         * @return boolean
         */
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
         * Setter
         * @param address the Customer's address to set
         * @return CustomerBuilder instance
         */
        public CustomerBuilder setAddress (String address) {
            this.address = address;
            return this;
        }
        /**
         * Setter
         * @param phoneNumber the Customer's phone number to set
         * @return CustomerBuilder instance
         */
        public CustomerBuilder setPhoneNumber (String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        /**
         * Setter
         * @param email the Customer's email to set
         * @return CustomerBuilder instance
         */
        public CustomerBuilder setEmail (String email) {
            this.email = email;
            return this;
        }
    }
}
