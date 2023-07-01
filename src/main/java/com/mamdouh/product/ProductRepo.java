package com.mamdouh.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mamdouh.registration.tocken.ConfirmationTocken;

public interface ProductRepo extends JpaRepository<Item,Long> {
	
    // Adds a new item to the database.
    Item save(Item item);
    
    // Retrieves an item with the specified ID.
    Optional<Item> findById(Long id);
    
    // Retrieves all items from the database.
    List<Item> findAll();
    
    // Deletes an item with the specified ID.
    void deleteById(Long id);
    
    // Updates an existing item.
    Item saveAndFlush(Item item);
    
    List<Item> findAllByName(String name);
    
    List<Item> findAllByGenresContaining(Category category);
    
}


