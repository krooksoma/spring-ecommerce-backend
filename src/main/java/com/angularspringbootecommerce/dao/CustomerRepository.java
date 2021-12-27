package com.angularspringbootecommerce.dao;


import com.angularspringbootecommerce.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
//Customer repository is not annotated and it will not be exposed
public interface CustomerRepository extends JpaRepository<Customer, Long> {
// SELECT * FROM customer WHERE c.email = theEmail
    // the method below returns null if not found
    Customer findByEmail(String theEmail);
}
