package com.angularspringbootecommerce.dao;

import com.angularspringbootecommerce.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Pageable;

//allows cross-origin from browsers running on 4200
//origin is the protocol + hostname + port
@CrossOrigin("http://localhost:4200")
public interface ProductRepository extends JpaRepository<Product, Long> {
    //the following method allows the query to be done using one of the default query methods provided by SB
    //options include, but not limited to, findBy, readBy, queryBy, the second element id the field to add to the argument
    //to create a custom query you can use the @Query annotation
    //the method below translates to: SELECT * FROM products WHERE category_id=?;
    Page<Product> findByCategoryId(@RequestParam("id") Long id, Pageable pageable);
}
