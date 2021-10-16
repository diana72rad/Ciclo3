/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.ciclo3.ciclo3.dao;

import co.usa.ciclo3.ciclo3.entities.Category;
import co.usa.ciclo3.ciclo3.entities.CategoryCrud;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 *
 * @author diana
 */
@Repository
public class CategoryRepository {
    @Autowired
    private CategoryCrud categoryCrudRepository;
    
public List<Category> getAll() {return (List<Category>) categoryCrudRepository.findAll();};
    
    public Optional<Category> getCategory(int id){
        return categoryCrudRepository.findById(id);
    };
    
     public Category save(Category category) { 
         return categoryCrudRepository.save(category);
     };
    
}
