package com.tallerMecanico.domain.model;

import com.tallerMecanico.domain.model.enums.ServiceStatus;
import com.tallerMecanico.domain.model.enums.ServiceType;

public class Service {
    private ServiceType type;
    private ServiceStatus status;
    
    public Service(ServiceType type, ServiceStatus status) {
        this.type = type;
        this.status = status;
    }

    public ServiceType getType() {
        return type;
    }

    public void setType(ServiceType type) {
        this.type = type;
    }

    public ServiceStatus getStatus() {
        return status;
    }

    public void setStatus(ServiceStatus status) {
        this.status = status;
    }
    
}
