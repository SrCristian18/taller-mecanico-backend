package com.tallerMecanico.infrastructure.adapter.out.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.tallerMecanico.domain.model.Vehicle;
import com.tallerMecanico.domain.ports.out.VehicleRepositoryPort;
import com.tallerMecanico.infrastructure.adapter.out.persistence.entity.VehicleEntity;
import com.tallerMecanico.infrastructure.adapter.out.persistence.mapper.VehicleMapper;
import com.tallerMecanico.infrastructure.adapter.out.persistence.repository.SpringDataVehicleRepository;

@Repository
public class VehicleRepositoryAdapter implements VehicleRepositoryPort{

    private final SpringDataVehicleRepository repository;

    public VehicleRepositoryAdapter(SpringDataVehicleRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Vehicle vehicle) {
        VehicleEntity entity = VehicleMapper.toEntity(vehicle);
        repository.save(entity);
    }

    @Override
    public Optional<Vehicle> findByPlate(String plate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByPlate'");
    }

    @Override
    public List<Vehicle> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public List<Vehicle> findHistory(String plate, String owner) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findHistory'");
    }

}
