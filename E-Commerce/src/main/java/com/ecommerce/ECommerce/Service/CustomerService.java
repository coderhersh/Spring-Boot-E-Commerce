package com.ecommerce.ECommerce.Service;

import com.ecommerce.ECommerce.Entity.Customer;
import com.ecommerce.ECommerce.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getCustomerList() {
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customers::add);
        return customers;
    }

    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void updateCustomer(Long id, Customer customer) {
        customerRepository.findById(id)
                .map(customer1 -> {
                    customer1.setName(customer.getName());
                    customer1.setAddress(customer.getAddress());
                    customer1.setAge(customer.getAge());
                    customer1.setDateOfBirth(customer.getDateOfBirth());
                    customer1.setPhoneNumber(customer.getPhoneNumber());
                    return customerRepository.save(customer);
                })
                .orElseGet(
                        () -> {
                            return customerRepository.save(customer);
                        }
                );
    }

    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }
}
