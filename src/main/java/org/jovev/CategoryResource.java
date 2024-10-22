package org.jovev;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.Set;

@Path("/category")
public class CategoryResource {

    private CategoryService categoryService;

    public CategoryResource(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @POST
    @Path("/{categoryName}/property/{categoryProperty}/value/{value}")
    public Category createCategoryProperty(@PathParam("categoryName") String categoryName, @PathParam("categoryProperty") String categoryProperty, @PathParam("value") String value){
        return categoryService.createCategoryAndProperty(categoryName, categoryProperty, value);
    }

    @GET
    @Path("/{categoryName}/property/{categoryProperty}")
    @Produces(MediaType.APPLICATION_JSON)
    public Category getCategoryProperty(@PathParam("categoryName") String categoryName, @PathParam("categoryProperty") String categoryProperty) {
        return categoryService.getCategoryByNameAndProperty(categoryName, categoryProperty);
    }


    @GET
    @Path("/{categoryName}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getAllCategoryProperties(@PathParam("categoryName") String categoryName){
        return categoryService.getCategoryProperties(categoryName);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Set<String> getAllCategories(){
        return categoryService.getAllCategories();
    }
}
