package com.tallerMecanico.infrastructure.persistence.repositories;

import com.tallerMecanico.infrastructure.persistence.entities.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaVehicleRepository extends JpaRepository<VehicleEntity, Long> {
    Optional<VehicleEntity> findByPlateAndActiveTrue(String plate);
    List<VehicleEntity> findAllByActiveTrue();
    List<VehicleEntity> findByPlateContainingIgnoreCaseOrOwnerNameContainingIgnoreCaseAndActiveTrue(String plate, String ownerName);
}
