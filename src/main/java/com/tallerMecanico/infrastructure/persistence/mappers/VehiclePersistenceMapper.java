package com.tallerMecanico.infrastructure.persistence.mappers;

import com.tallerMecanico.domain.model.Owner;
import com.tallerMecanico.domain.model.Service;
import com.tallerMecanico.domain.model.Vehicle;
import com.tallerMecanico.infrastructure.persistence.entities.OwnerEntity;
import com.tallerMecanico.infrastructure.persistence.entities.ServiceEmbedded;
import com.tallerMecanico.infrastructure.persistence.entities.VehicleEntity;
import org.springframework.stereotype.Component;

@Component
public class VehiclePersistenceMapper {

    public Vehicle toDomain(VehicleEntity entity) {
        if (entity == null) return null;

        Owner owner = new Owner(entity.getOwner().getName(), entity.getOwner().getPhone());
        owner.setActive(entity.getOwner().isActive());

        Service service = new Service(entity.getService().getType(), entity.getService().getStatus());

        Vehicle vehicle = new Vehicle(
                entity.getPlate(),
                entity.getBrand(),
                entity.getModel(),
                owner,
                service,
                entity.getEntryDate()
        );
        vehicle.setExitDate(entity.getExitDate());
        vehicle.setActive(entity.isActive());

        return vehicle;
    }

    public VehicleEntity toEntity(Vehicle domain, OwnerEntity ownerEntity) {
        if (domain == null) return null;

        ServiceEmbedded serviceEmbedded = ServiceEmbedded.builder()
                .type(domain.getService().getType())
                .status(domain.getService().getStatus())
                .build();

        return VehicleEntity.builder()
                .plate(domain.getPlate())
                .brand(domain.getBrand())
                .model(domain.getModel())
                .owner(ownerEntity)
                .service(serviceEmbedded)
                .entryDate(domain.getEntryDate())
                .exitDate(domain.getExitDate())
                .active(domain.isActive())
                .build();
    }
}
