package com.ecommerce.ECommerce.Controller;

import com.ecommerce.ECommerce.Entity.Customer;
import com.ecommerce.ECommerce.Service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
    Logger logger = LoggerFactory.getLogger(CustomerController.class);
    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/get-customer-list")
    public List<Customer> getCustomerList() {
        return customerService.getCustomerList();
    }

    @GetMapping(value = "/get-customer/id/{id}")
    public Optional<Customer> findById(@PathVariable Long id) {
        return customerService.findById(id);
    }

    @PostMapping(value = "/add-customer")
    public void addCustomer(@RequestBody Customer customer) {
        logger.info("Before adding..");
        customerService.addCustomer(customer);
        logger.info("After adding..");
    }

    @PutMapping(value = "update-customer/id/{id}")
    public void updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        customerService.updateCustomer(id, customer);
    }

    @DeleteMapping(value = "delete-customer/id/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomerById(id);
    }
}
