package com.tallerMecanico.application.service;

import com.tallerMecanico.domain.event.EventType;
import com.tallerMecanico.domain.event.VehicleEvent;
import com.tallerMecanico.domain.model.ServiceStatus;
import com.tallerMecanico.domain.model.Vehicle;
import com.tallerMecanico.domain.ports.in.VehicleUseCase;
import com.tallerMecanico.domain.ports.out.EventPublisherPort;
import com.tallerMecanico.domain.ports.out.VehicleRepositoryPort;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class VehicleService implements VehicleUseCase {

    private final VehicleRepositoryPort repositoryPort;
    private final EventPublisherPort eventPublisherPort;

    public VehicleService(VehicleRepositoryPort repositoryPort,
            EventPublisherPort eventPublisherPort) {
        this.repositoryPort = repositoryPort;
        this.eventPublisherPort = eventPublisherPort;
    }

    @Override
    public void registerVehicle(Vehicle vehicle) {
        vehicle.setEntryDate(LocalDateTime.now());
        vehicle.getService().setStatus(ServiceStatus.EN_ESPERA);
        vehicle.setActive(true);
//        repositoryPort.save(vehicle);
        Vehicle savedVehicle = repositoryPort.save(vehicle);
        eventPublisherPort.publish(
            new VehicleEvent(
                EventType.VEHICLE_REGISTERED.name(),
                savedVehicle.getPlate(),
                "Vehículo registrado",
                LocalDateTime.now()
            )
        );
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
            eventPublisherPort.publish(
                new VehicleEvent(
                    EventType.VEHICLE_STATUS_CHANGED.name(),
                    vehicle.getPlate(),
                    "Estado cambiado a "+ status,
                    LocalDateTime.now()
                )
            );
        });
    }

    @Override
    public void finishService(String plate) {
        repositoryPort.findByPlate(plate).ifPresent(vehicle -> {
            vehicle.getService().setStatus(ServiceStatus.FINALIZADO);
            vehicle.setExitDate(LocalDateTime.now());
            repositoryPort.save(vehicle);
            eventPublisherPort.publish(
                new VehicleEvent(
                    EventType.VEHICLE_SERVICE_FINISHED.name(),
                    vehicle.getPlate(),
                    "Servicio finalizado",
                    LocalDateTime.now()
                )
            );
        });
    }

    @Override
    public List<Vehicle> getHistory(String plate, String owner) {
        return repositoryPort.findHistory(plate, owner);
    }
}
