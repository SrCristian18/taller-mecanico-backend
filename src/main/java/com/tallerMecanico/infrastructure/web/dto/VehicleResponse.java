package com.tallerMecanico.infrastructure.web.dto;

import com.tallerMecanico.domain.model.ServiceStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehicleResponse {
    private String plate;
    private String brand;
    private String model;
    private String ownerName;
    private String ownerPhone;
    private String serviceType;
    private ServiceStatus status;
    private LocalDateTime entryDate;
    private LocalDateTime exitDate;
    private Long totalTimeMinutes;
}
