package org.jovev;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import org.bson.codecs.pojo.annotations.BsonProperty;


/**
 * Example JPA entity defined as a Panache Entity.
 * An ID field of Long type is provided, if you want to define your own ID field extends <code>PanacheEntityBase</code> instead.
 *
 * This uses the active record pattern, you can also use the repository pattern instead:
 * .
 *
 * Usage (more example on the documentation)
 *
 * {@code
 *     public void doSomething() {
 *         MyEntity entity1 = new MyEntity();
 *         entity1.field = "field-1";
 *         entity1.persist();
 *
 *         List<MyEntity> entities = MyEntity.listAll();
 *     }
 * }
 */
@MongoEntity(collection = "panache-category")
public class Category extends PanacheMongoEntity {

    @BsonProperty("category_name")
    private String categoryName;

    @BsonProperty("category_property")
    private String categoryProperty;
    @BsonProperty("property_value")
    private String categoryValue;

    public Category(String categoryName){
        this.categoryName = categoryName;
    }

    public Category(){}

    public Category(String categoryName, String categoryProperty, String categoryValue){
        this.categoryName = categoryName;
        this.categoryProperty = categoryProperty;
        this.categoryValue = categoryValue;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getCategoryProperty() {
        return categoryProperty;
    }

    public String getCategoryValue(){
        return categoryValue;
    }

    public void setCategoryName(String companyName){
        this.categoryName = companyName;
    }

    public void setCategoryProperty(String property){
        this.categoryProperty = property;
    }

    public void setCategoryValue(String value){
        this.categoryValue = value;
    }
}
