package com.tallerMecanico.domain.ports.out;

import java.util.List;
import java.util.Optional;

import com.tallerMecanico.domain.model.Vehicle;

public interface VehicleRepositoryPort {
    void save(Vehicle vehicle);

    Optional<Vehicle> findByPlate(String plate);

    List<Vehicle> findAll();

    List<Vehicle> findHistory(String plate, String owner);
}
