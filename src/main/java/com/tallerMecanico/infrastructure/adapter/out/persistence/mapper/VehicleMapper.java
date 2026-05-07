package com.tallerMecanico.infrastructure.adapter.out.persistence.mapper;

import com.tallerMecanico.domain.model.Vehicle;
import com.tallerMecanico.infrastructure.adapter.out.persistence.entity.VehicleEntity;

public class VehicleMapper {
    public static VehicleEntity toEntity(Vehicle vehicle){
        return new VehicleEntity();
    }
    public static Vehicle toDomain(VehicleEntity entity){
        return new Vehicle();
    }
}
