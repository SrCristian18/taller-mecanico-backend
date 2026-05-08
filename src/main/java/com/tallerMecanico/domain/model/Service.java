package com.tallerMecanico.domain.model;

public class Service {
    private String type;
    private ServiceStatus status;

    public Service() {
    }

    public Service(String type, ServiceStatus status) {
        this.type = type;
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ServiceStatus getStatus() {
        return status;
    }

    public void setStatus(ServiceStatus status) {
        this.status = status;
    }
}
