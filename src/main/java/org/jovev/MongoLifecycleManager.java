package org.jovev;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class MongoLifecycleManager {

    @Inject
    MongoClient mongoClient;

    @Inject
    CategoryRepository categoryRepository;

    public void onStart(@Observes StartupEvent event) {
        MongoDatabase database = mongoClient.getDatabase("category-db");
        System.out.println("Application is starting, creating collections...");
        // You can create collections if necessary, e.g.:
        database.createCollection("panache-category");
        List<Category> cache = new ArrayList<>();
        cache.addAll(categoryRepository.listAll());
        categoryRepository.persist(new Category("Iskratel", "prop1", "val1"));
        categoryRepository.persist(new Category("Iskratel", "prop2", "val2"));
        categoryRepository.persist(new Category("Iskratel", "prop3", "val3"));
        categoryRepository.persist(new Category("Iskratel", "prop4", "val4"));
        categoryRepository.persist(new Category("Iskratel", "prop5", "val5"));
        categoryRepository.persist(new Category("Jabolko", "prop1", "val1"));
        categoryRepository.persist(new Category("Banana", "prop2", "val2"));
        categoryRepository.persist(new Category("Kola", "prop3", "val3"));
        categoryRepository.persist(new Category("Nesto", "prop4", "val4"));
        categoryRepository.persist(new Category("MnoguSe", "prop5", "val5"));
    }

    public void onStop(@Observes ShutdownEvent event) {
        MongoDatabase database = mongoClient.getDatabase("my_database");
        System.out.println("Application is stopping, dropping collections...");
        // Drop collections when the application stops
        database.getCollection("panache-category").drop();
        categoryRepository.deleteAll();
    }
}
