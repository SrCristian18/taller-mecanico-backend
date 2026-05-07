package com.tallerMecanico.infrastructure.adapter.out.persistence.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehicle")
public class VehicleEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String plate;
    private String brand; 
    private String model; 
    private String owner_name; 
    private String owner_phone; 
    private String service_type; 
    private String status; 
    private Date entry_date; 
    private Date exit_date;
    
    public VehicleEntity() {
    }

    public VehicleEntity(long id, String plate, String brand, String model, String owner_name, String owner_phone,
            String service_type, String status, Date entry_date, Date exit_date) {
        this.id = id;
        this.plate = plate;
        this.brand = brand;
        this.model = model;
        this.owner_name = owner_name;
        this.owner_phone = owner_phone;
        this.service_type = service_type;
        this.status = status;
        this.entry_date = entry_date;
        this.exit_date = exit_date;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getPlate() {
        return plate;
    }
    public void setPlate(String plate) {
        this.plate = plate;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getOwner_name() {
        return owner_name;
    }
    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }
    public String getOwner_phone() {
        return owner_phone;
    }
    public void setOwner_phone(String owner_phone) {
        this.owner_phone = owner_phone;
    }
    public String getService_type() {
        return service_type;
    }
    public void setService_type(String service_type) {
        this.service_type = service_type;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Date getEntry_date() {
        return entry_date;
    }
    public void setEntry_date(Date entry_date) {
        this.entry_date = entry_date;
    }
    public Date getExit_date() {
        return exit_date;
    }
    public void setExit_date(Date exit_date) {
        this.exit_date = exit_date;
    } 

}
