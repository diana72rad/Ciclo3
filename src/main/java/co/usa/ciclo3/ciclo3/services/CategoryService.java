/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.ciclo3.ciclo3.services;

import co.usa.ciclo3.ciclo3.dao.CategoryRepository;
import co.usa.ciclo3.ciclo3.entities.Category;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author diana
 */
@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    
    public List<Category> getAll() {
        return (List<Category>) categoryRepository.getAll();
     }
    
    public Optional<Category> getCategory(int id) {
        return categoryRepository.getCategory(id);
    }
    
    public Category save(Category category) { 
       if (category.getId()== null){
           return categoryRepository.save(category);
       }
       else
       {
          Optional<Category> co =  categoryRepository.getCategory(category.getId());
          if (co.isEmpty()){
              return categoryRepository.save(category);
          }
          else
          {
              return category;
          }
       }
 
    }
    
    public Category update(Category category){
        if(category.getId()!=null){
            Optional<Category>g=categoryRepository.getCategory(category.getId());
            if(!g.isEmpty()){
                if(category.getName()!=null){
                    g.get().setName(category.getName());
                }
                if(category.getDescription()!=null){
                    g.get().setDescription(category.getDescription());
                }
                
                return categoryRepository.save(g.get());

            }
        }
        return category;

    }

    public boolean deleteCategory(int id){
        Optional<Category> category=getCategory(id);
        if(!category.isEmpty()){
            categoryRepository.delete(category.get());
            return true;
        }
        return false;

    }



}
