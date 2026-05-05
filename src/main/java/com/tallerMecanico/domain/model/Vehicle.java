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
    
    public Vehicle(String plate, String brand, String model, Owner owner, Service service, LocalDateTime entryDate,
        LocalDateTime exitDate) {
        this.plate = plate;
        this.brand = brand;
        this.model = model;
        this.owner = owner;
        this.service = service;
        this.entryDate = entryDate;
        this.exitDate = exitDate;
    }

}
