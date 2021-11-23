package com.example.demo.customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    private static final List<Customer> CUSTOMERS = Arrays.asList(
            new Customer(1, "Pepe", "Viyuela", "pepeviyuela@aida.com"),
            new Customer(2, "Milagros", "del Monte", "milamonte@gmail.com"),
            new Customer(3, "Tomás", "Turbado", "tomasturbado@yahoo.es")
    );

    @GetMapping(path = "{customerId}")
    public Customer getCustomer(@PathVariable("customerId") Integer customerId){
        //customerId is the /{customerId}
        return CUSTOMERS.stream()
                .filter(customer -> customerId.equals(customer.getCustomerId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Customer " + customerId + " does not exist!"));
    }

}
