/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.ciclo3.ciclo3.services;

import co.usa.ciclo3.ciclo3.dao.ClientRepository;
import co.usa.ciclo3.ciclo3.entities.Client;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author diana
 */
@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;
    
    public List<Client> getAll() {
        return (List<Client>) clientRepository.getAll();
     }
    
    public Optional<Client> getClient(int id) {
        return clientRepository.getClient(id);
    }
    
    public Client save(Client client) { 
       if (client.getIdClient()== null){
           return clientRepository.save(client);
       }
       else
       {
          Optional<Client> co =  clientRepository.getClient(client.getIdClient());
          if (co.isEmpty()){
              return clientRepository.save(client);
          }
          else
          {
              return client;
          }
       }
 
    }
    
    public Client update(Client client){
        if(client.getIdClient()!=null){
            Optional<Client>g=clientRepository.getClient(client.getIdClient());
            if(!g.isEmpty()){
                if(client.getEmail()!=null){
                    g.get().setEmail(client.getEmail());
                }
                if(client.getPassword()!=null){
                    g.get().setPassword(client.getPassword());
                }
                if(client.getName()!=null){
                    g.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    g.get().setAge(client.getAge());
                }
                return clientRepository.save(g.get());

            }
        }
        return client;

    }

    public boolean deleteClient(int id){
        Optional<Client> client=getClient(id);
        if(!client.isEmpty()){
            clientRepository.delete(client.get());
            return true;
        }
        return false;

    }
}
