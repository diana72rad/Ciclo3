/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.ciclo3.ciclo3.entities;

import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author diana
 */
public interface MessageCrud extends CrudRepository<Message, Integer>{
    
}
