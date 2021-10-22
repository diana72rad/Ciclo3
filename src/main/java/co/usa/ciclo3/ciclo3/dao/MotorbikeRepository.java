/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.ciclo3.ciclo3.dao;

import co.usa.ciclo3.ciclo3.entities.Motorbike;
import co.usa.ciclo3.ciclo3.entities.MotorbikeCrud;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 *
 * @author diana
 */
@Repository
public class MotorbikeRepository {
    @Autowired
    private MotorbikeCrud motorbikeCrudRepository;
    
    public List<Motorbike> getAll() {
        return (List<Motorbike>) motorbikeCrudRepository.findAll();};
    
    public Optional<Motorbike> getMotorbike(int id){
        return motorbikeCrudRepository.findById(id);
    };
    
    public Motorbike save(Motorbike motorbike) { 
         return motorbikeCrudRepository.save(motorbike);
     };
    
    public void delete(Motorbike motorbike) {
        motorbikeCrudRepository.delete(motorbike);
    };
}
