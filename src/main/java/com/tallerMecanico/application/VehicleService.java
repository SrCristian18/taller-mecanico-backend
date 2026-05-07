package com.tallerMecanico.application;

import java.util.List;

import com.tallerMecanico.domain.model.Vehicle;
import com.tallerMecanico.domain.model.enums.ServiceStatus;
import com.tallerMecanico.domain.ports.in.VehicleUseCase;
import com.tallerMecanico.domain.ports.out.VehicleRepositoryPort;

public class VehicleService implements VehicleUseCase{

    private final VehicleRepositoryPort repository;

    public VehicleService (VehicleRepositoryPort repository){
        this.repository = repository;
    }

    @Override
    public void registerVehicle(Vehicle vehicle) {
        repository.save(vehicle);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllVehicles'");
    }

    @Override
    public void updateStatus(String plate, ServiceStatus status) {
        Vehicle v = repository.findByPlate(plate).orElseThrow();
        v.getService().setStatus(status);
        repository.save(v);
    }

    @Override
    public void finishService(String plate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'finishService'");
    }

    @Override
    public List<Vehicle> getHistory(String plate, String owner) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getHistory'");
    }
    
}
