package com.angularspringbootecommerce.dao;

import com.angularspringbootecommerce.entities.Product;
import com.angularspringbootecommerce.entities.ProductCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

//RepositoryRestResource -> collectionResourceRel is the name of the Json Entry, path is the url path for the category : product-category
//this allows you to customize the path instead of using the standard path that only adds and 's' to the end
@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "productCategory", path ="product-category")
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

    Page<Product> findByCategoryId(@RequestParam("id")Long id, Pageable pageable);
}
