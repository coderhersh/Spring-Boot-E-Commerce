package com.ecommerce.ECommerce.Repository;

import com.ecommerce.ECommerce.Entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
