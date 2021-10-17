/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.ciclo3.ciclo3.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 *
 * @author diana
 */
@Entity
@Table (name="motorbike")
public class Motorbike implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String brand;
    private Integer year;
    private String description;

/**
 *
 * Declaraciòn de las relaciones entre tablas
 */
    @ManyToOne
    @JoinColumn (name="idCategory")
    @JsonIgnoreProperties("motorbikes")
    private Category category;

      
    @OneToMany(cascade={CascadeType.PERSIST},mappedBy= "motorbike")
    @JsonIgnoreProperties({"motorbike","client"})
    private List<Message> messages;
    
    @OneToMany(cascade={CascadeType.PERSIST},mappedBy= "motorbike")
    @JsonIgnoreProperties({"motorbike","messages"})
    private List<Reservation> reservations;

/**
 *
 * Mètodo get para obtener el Id
 */
    public Integer getId() {
        return id;
    }
/**
 *
 * Mètodo set para Id
 */
    public void setId(Integer id) {
        this.id = id;
    }
/**
 *
 * Mètodo get para obtener el name
 */
    public String getName() {
        return name;
    }
/**
 *
 * Mètodo set para el nombre
 */
    public void setName(String name) {
        this.name = name;
    }

/**
 *
 * Mètodo get para obtener la marca
 */
    public String getBrand() {
        return brand;
    }
/**
 *
 * Mètodo set para la marca
 */
    public void setBrand(String brand) {
        this.brand = brand;
    }
/**
 *
 * Mètodo get para obtener el año
 */
    public Integer getYear() {
        return year;
    }
/**
 *
 * Mètodo set para el año
 */
    public void setYear(Integer year) {
        this.year = year;
    }
/**
 *
 * Mètodo get para obtener la descripciòn
 */
    public String getDescription() {
        return description;
    }
/**
 *
 * Mètodo set para la descripcion
 */
    public void setDescription(String description) {
        this.description = description;
    }
/**
 *
 * Mètodo get para obtener la categorìa
 */
    public Category getCategory() {
        return category;
    }
/**
 *
 * Mètodo set para la categorìa a la que se relaciona una motocicleta
 */
    public void setCategory(Category category) {
        this.category = category;
    }
/**
 *
 * Mètodo get para obtener los mensajes relacionados a una motocicleta
 */
    public List<Message> getMessages() {
        return messages;
    }
/**
 *
 * Mètodo set para los mensajes relacionados a una motocicleta
 */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
/**
 *
 * Mètodo get para obtener las reservaciones relacioandas a una motocicleta
 */
    public List<Reservation> getReservations() {
        return reservations;
    }
/**
 *
 * Mètodo set para las reservaciones relacionadas a una motocicleta
 */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
