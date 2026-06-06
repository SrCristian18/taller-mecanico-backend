package com.tallerMecanico.domain.event;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class VehicleEvent {

    private String eventType;
    private String vehiclePlate;
    private String description;
    private LocalDateTime occurredAt;

    public String getEventType() {
        return eventType;
    }

    public String getVehiclePlate() {
        return vehiclePlate;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getOccurredAt() {
        return occurredAt;
    }
}