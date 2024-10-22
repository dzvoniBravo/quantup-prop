package org.jovev;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class CategoryRepository implements PanacheMongoRepository<Category> {

    public Category getCategoryByNameAndProperty(String categoryName, String categoryProperty){
        return find("category_name = ?1 and category_property = ?2", categoryName, categoryProperty).firstResult();
    }

    public List<Category> getCategoryByName(String categoryName){
        return find("category_name", categoryName).list();
    }

}
