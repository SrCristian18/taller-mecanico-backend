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
}
