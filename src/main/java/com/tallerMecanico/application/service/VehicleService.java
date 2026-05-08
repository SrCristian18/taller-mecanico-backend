package com.tallerMecanico.application.service;

import com.tallerMecanico.domain.model.ServiceStatus;
import com.tallerMecanico.domain.model.Vehicle;
import com.tallerMecanico.domain.ports.in.VehicleUseCase;
import com.tallerMecanico.domain.ports.out.VehicleRepositoryPort;

import java.time.LocalDateTime;
import java.util.List;

public class VehicleService implements VehicleUseCase {

    private final VehicleRepositoryPort repositoryPort;

    public VehicleService(VehicleRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public void registerVehicle(Vehicle vehicle) {
        vehicle.setEntryDate(LocalDateTime.now());
        vehicle.getService().setStatus(ServiceStatus.EN_ESPERA);
        vehicle.setActive(true);
        repositoryPort.save(vehicle);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return repositoryPort.findAll();
    }

    @Override
    public void updateStatus(String plate, ServiceStatus status) {
        repositoryPort.findByPlate(plate).ifPresent(vehicle -> {
            vehicle.getService().setStatus(status);
            repositoryPort.save(vehicle);
        });
    }

    @Override
    public void finishService(String plate) {
        repositoryPort.findByPlate(plate).ifPresent(vehicle -> {
            vehicle.getService().setStatus(ServiceStatus.FINALIZADO);
            vehicle.setExitDate(LocalDateTime.now());
            repositoryPort.save(vehicle);
        });
    }

    @Override
    public List<Vehicle> getHistory(String plate, String owner) {
        return repositoryPort.findHistory(plate, owner);
    }
}
