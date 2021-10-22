/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.ciclo3.ciclo3.services;

import co.usa.ciclo3.ciclo3.dao.MotorbikeRepository;
import co.usa.ciclo3.ciclo3.entities.Motorbike;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author diana
 */
@Service
public class MotorbikeService {
    @Autowired
    MotorbikeRepository motorbikeRepository;
    
    public List<Motorbike> getAll() {
        return (List<Motorbike>) motorbikeRepository.getAll();
     }
    
    public Optional<Motorbike> getMotorbike(int id) {
        return motorbikeRepository.getMotorbike(id);
    }
    
    public Motorbike save(Motorbike motorbike) { 
       if (motorbike.getId()== null){
           return motorbikeRepository.save(motorbike);
       }
       else
       {
          Optional<Motorbike> co =  motorbikeRepository.getMotorbike(motorbike.getId());
          if (co.isEmpty()){
              return motorbikeRepository.save(motorbike);
          }
          else
          {
              return motorbike;
          }
       }
 
    }
    
    public Motorbike update(Motorbike motorbike){
        if(motorbike.getId()!=null){
            Optional<Motorbike>g=motorbikeRepository.getMotorbike(motorbike.getId());
            if(!g.isEmpty()){
                if(motorbike.getName()!=null){
                    g.get().setName(motorbike.getName());
                }
                if(motorbike.getBrand()!=null){
                    g.get().setBrand(motorbike.getBrand());
                }
                if(motorbike.getYear()!=null){
                    g.get().setYear(motorbike.getYear());
                }
                if(motorbike.getDescription()!=null){
                    g.get().setDescription(motorbike.getDescription());
                }
                return motorbikeRepository.save(g.get());

            }
        }
        return motorbike;

    }

    public boolean deleteMotorbike(int id){
        Optional<Motorbike> motorbike=getMotorbike(id);
        if(!motorbike.isEmpty()){
            motorbikeRepository.delete(motorbike.get());
            return true;
        }
        return false;

    }
    
}
