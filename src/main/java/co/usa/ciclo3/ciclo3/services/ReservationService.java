/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.ciclo3.ciclo3.services;

import co.usa.ciclo3.ciclo3.dao.ReservationRepository;
import co.usa.ciclo3.ciclo3.entities.Reservation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author diana
 */
@Service
public class ReservationService {
    @Autowired
    ReservationRepository reservationRepository;
    
    public List<Reservation> getAll() {
        return (List<Reservation>) reservationRepository.getAll();
     }
    
    public Optional<Reservation> getReservation(int id) {
        return reservationRepository.getReservation(id);
    }
    
    public Reservation save(Reservation reservation) { 
       if (reservation.getIdReservation()== null){
           return reservationRepository.save(reservation);
       }
       else
       {
          Optional<Reservation> co =  reservationRepository.getReservation(reservation.getIdReservation());
          if (co.isEmpty()){
              return reservationRepository.save(reservation);
          }
          else
          {
              return reservation;
          }
       }
 
    }
    
    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation>g=reservationRepository.getReservation(reservation.getIdReservation());
            if(!g.isEmpty()){
                if(reservation.getStartDate()!=null){
                    g.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    g.get().setDevolutionDate(reservation.getStartDate());
                }
                return reservationRepository.save(g.get());

            }
        }
        return reservation;

    }

    public boolean deleteReservation(int id){
        Optional<Reservation> reservation=getReservation(id);
        if(!reservation.isEmpty()){
            reservationRepository.delete(reservation.get());
            return true;
        }
        return false;

    }
    
}
