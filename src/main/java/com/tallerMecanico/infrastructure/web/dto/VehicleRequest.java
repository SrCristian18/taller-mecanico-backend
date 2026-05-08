package com.tallerMecanico.infrastructure.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehicleRequest {
    private String plate;
    private String brand;
    private String model;
    private String ownerName;
    private String ownerPhone;
    private String serviceType;
}
