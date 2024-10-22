package org.jovev;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@ApplicationScoped
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category getCategoryByNameAndProperty(String categoryName, String categoryProperty){
        return categoryRepository.getCategoryByNameAndProperty(categoryName, categoryProperty);
    }

    public Category createCategoryAndProperty(String categoryName, String categoryProperty, String value) {
        Category category = categoryRepository.getCategoryByNameAndProperty(categoryName, categoryProperty);
        if(category == null){
            category = new Category(categoryName, categoryProperty, value);
            categoryRepository.persist(category);
            return category;
        }
        throw new IllegalStateException("Property for that value already exists!");
    }

    public List<String> getCategoryProperties(String categoryName){
        return categoryRepository.getCategoryByName(categoryName).stream().map(Category::getCategoryProperty).toList();
    }

    public Set<String> getAllCategories(){
        return categoryRepository.findAll().stream().map(Category::getCategoryName).collect(Collectors.toSet());
    }
}
