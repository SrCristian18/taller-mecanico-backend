package com.tallerMecanico.infrastructure.persistence.adapters;

import com.tallerMecanico.domain.model.Vehicle;
import com.tallerMecanico.domain.ports.out.VehicleRepositoryPort;
import com.tallerMecanico.infrastructure.persistence.entities.OwnerEntity;
import com.tallerMecanico.infrastructure.persistence.entities.VehicleEntity;
import com.tallerMecanico.infrastructure.persistence.mappers.VehiclePersistenceMapper;
import com.tallerMecanico.infrastructure.persistence.repositories.JpaOwnerRepository;
import com.tallerMecanico.infrastructure.persistence.repositories.JpaVehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class JpaVehicleRepositoryAdapter implements VehicleRepositoryPort {

    private final JpaVehicleRepository jpaVehicleRepository;
    private final JpaOwnerRepository jpaOwnerRepository;
    private final VehiclePersistenceMapper mapper;

    @Override
    public Vehicle save(Vehicle vehicle) {
        OwnerEntity ownerEntity = jpaOwnerRepository.findByNameAndPhone(
                vehicle.getOwner().getName(), 
                vehicle.getOwner().getPhone()
        ).orElseGet(() -> jpaOwnerRepository.save(OwnerEntity.builder()
                .name(vehicle.getOwner().getName())
                .phone(vehicle.getOwner().getPhone())
                .active(true)
                .build()));

        VehicleEntity entity = mapper.toEntity(vehicle, ownerEntity);
        
        // If it's an update, find existing ID
        jpaVehicleRepository.findByPlateAndActiveTrue(vehicle.getPlate())
                .ifPresent(existing -> entity.setId(existing.getId()));
        
        jpaVehicleRepository.save(entity);
        return vehicle;
    }

    @Override
    public Optional<Vehicle> findByPlate(String plate) {
        return jpaVehicleRepository.findByPlateAndActiveTrue(plate)
                .map(mapper::toDomain);
    }

    @Override
    public List<Vehicle> findAll() {
        return jpaVehicleRepository.findAllByActiveTrue().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Vehicle> findHistory(String plate, String owner) {
        if ((plate == null || plate.trim().isEmpty()) && (owner == null || owner.trim().isEmpty())) {
            return jpaVehicleRepository.findAllByActiveTrue().stream()
                    .map(mapper::toDomain)
                    .collect(Collectors.toList());
        }
        
        String searchPlate = plate != null ? plate : "";
        String searchOwner = owner != null ? owner : searchPlate;
        
        return jpaVehicleRepository.findByPlateContainingIgnoreCaseOrOwnerNameContainingIgnoreCaseAndActiveTrue(searchPlate, searchOwner)
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
}
