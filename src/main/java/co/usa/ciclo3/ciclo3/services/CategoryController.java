/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.ciclo3.ciclo3.services;

import co.usa.ciclo3.ciclo3.entities.Category;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author diana
 */
@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*", methods={RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})


public class CategoryController {
    @Autowired
    
    private CategoryService categoryService;
    
    @GetMapping("/all")
    public List<Category> getCategorys() {
        return categoryService.getAll();
    };
    
    @GetMapping("/{idCategory}")
    public Optional<Category> getCategory(@PathVariable("idCategory") int categoryId) {
        return categoryService.getCategory(categoryId);
    }
   
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category category) {
        return categoryService.save(category);
    };
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Category update(@RequestBody Category category){
        return categoryService.update(category);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteCategory(@PathVariable("id") int id){
        return categoryService.deleteCategory(id);
    }
    
    
}
