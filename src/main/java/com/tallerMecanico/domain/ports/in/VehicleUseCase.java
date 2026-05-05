package com.tallerMecanico.domain.ports.in;

import java.util.List;

import com.tallerMecanico.domain.model.ServiceStatus;
import com.tallerMecanico.domain.model.Vehicle;

public interface VehicleUseCase {
    void registerVehicle(Vehicle vehicle);

    List<Vehicle> getAllVehicles();

    void updateStatus(String plate, ServiceStatus status);

    void finishService(String plate);

    List<Vehicle> getHistory(String plate, String owner);
}
