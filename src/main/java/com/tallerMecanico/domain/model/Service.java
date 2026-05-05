package com.tallerMecanico.domain.model;

public class Service {
    private String type;
    private ServiceStatus status;
    
    public Service(String type, ServiceStatus status) {
        this.type = type;
        this.status = status;
    }
    
}
