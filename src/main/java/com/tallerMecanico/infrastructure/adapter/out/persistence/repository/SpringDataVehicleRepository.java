package com.tallerMecanico.infrastructure.adapter.out.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tallerMecanico.infrastructure.adapter.out.persistence.entity.VehicleEntity;

public interface SpringDataVehicleRepository extends JpaRepository<VehicleEntity, Long>{
    Optional<VehicleEntity> findByPlate(String plate);
}