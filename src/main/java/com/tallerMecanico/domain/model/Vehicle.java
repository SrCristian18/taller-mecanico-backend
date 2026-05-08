package com.tallerMecanico.domain.model;

import java.time.LocalDateTime;

public class Vehicle {
    private String plate;
    private String brand;
    private String model;
    private Owner owner;
    private Service service;
    private LocalDateTime entryDate;
    private LocalDateTime exitDate;
    private boolean active = true;

    public Vehicle() {
    }

    public Vehicle(String plate, String brand, String model, Owner owner, Service service, LocalDateTime entryDate) {
        this.plate = plate;
        this.brand = brand;
        this.model = model;
        this.owner = owner;
        this.service = service;
        this.entryDate = entryDate;
        this.active = true;
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

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public LocalDateTime getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDateTime entryDate) {
        this.entryDate = entryDate;
    }

    public LocalDateTime getExitDate() {
        return exitDate;
    }

    public void setExitDate(LocalDateTime exitDate) {
        this.exitDate = exitDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
