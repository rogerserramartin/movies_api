package com.example.demo.customer;

public class Customer {

    private final Integer customerId;
    private final String customerName;
    private final String lastName;
    private final String email;

    public Customer(Integer customerId, String customerName, String lastName, String email) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.lastName = lastName;
        this.email = email;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
}
