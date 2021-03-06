/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.ciclo3.ciclo3.services;

import co.usa.ciclo3.ciclo3.dao.MessageRepository;
import co.usa.ciclo3.ciclo3.entities.Message;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author diana
 */
@Service
public class MessageService {
    @Autowired
    MessageRepository messageRepository;
    
 
    public List<Message> getAll() {
        return (List<Message>) messageRepository.getAll();
    }
  
    public Optional<Message> getMessage(int id) {
        return messageRepository.getMessage(id);
    }
  
    public Message save(Message message) { 
       if (message.getIdMessage()== null){
           return messageRepository.save(message);
       }
       else
       {
          Optional<Message> co =  messageRepository.getMessage(message.getIdMessage());
          if (co.isEmpty()){
              return messageRepository.save(message);
          }
          else
          {
              return message;
          }
       }
 
    }
    
    public Message update(Message message){
        if(message.getIdMessage()!=null){
            Optional<Message>g=messageRepository.getMessage(message.getIdMessage());
            if(!g.isEmpty()){
                if(message.getMessageText()!=null){
                    g.get().setMessageText(message.getMessageText());
                }
                return messageRepository.save(g.get());

            }
        }
        return message;

    }

    public boolean deleteMessage(int id){
        Optional<Message> message=getMessage(id);
        if(!message.isEmpty()){
            messageRepository.delete(message.get());
            return true;
        }
        return false;

    }
    
}
