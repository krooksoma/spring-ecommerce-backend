package com.angularspringbootecommerce.config;

import com.angularspringbootecommerce.entities.Product;
import com.angularspringbootecommerce.entities.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

//this set of configuration makes the api read-only no put, post or delete methods allowed
//Configuration annotations allows this class to be scanned as an item
@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {
    private final EntityManager entityManager;

    @Autowired
    public MyDataRestConfig(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
//        http methods that are disabled
        HttpMethod[] theUnsupportedActions = {HttpMethod.POST, HttpMethod.PUT, HttpMethod.DELETE};

        exposedIds(config);
//        withItemExposure disables for a single item
        // withCollectionExposure disables for a collection
        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions)))
                .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions)));

        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions)))
                .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions)));
    }

    private void exposedIds(RepositoryRestConfiguration configuration){
        //expose entity ids

        // get list of all entity identities from Entity Manager
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

        //Create an array of the entity types
        List<Class> entityClasses = new ArrayList<>();
        //get the identity type for the entities
        for(EntityType<?> tempEntityType : entities){
            entityClasses.add(tempEntityType.getJavaType());
        }
        //expose the entity ids for the array of identity/domain types
        Class[] domainTypes = entityClasses.toArray(new Class[0]);
        configuration.exposeIdsFor(domainTypes);
    }
}
