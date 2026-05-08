package com.tallerMecanico.infrastructure.web.mappers;

import com.tallerMecanico.domain.model.Owner;
import com.tallerMecanico.domain.model.Service;
import com.tallerMecanico.domain.model.Vehicle;
import com.tallerMecanico.infrastructure.web.dto.VehicleRequest;
import com.tallerMecanico.infrastructure.web.dto.VehicleResponse;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class VehicleWebMapper {

    public Vehicle toDomain(VehicleRequest request) {
        if (request == null) return null;

        Owner owner = new Owner(request.getOwnerName(), request.getOwnerPhone());
        Service service = new Service(request.getServiceType(), null);

        return new Vehicle(
                request.getPlate(),
                request.getBrand(),
                request.getModel(),
                owner,
                service,
                null
        );
    }

    public VehicleResponse toResponse(Vehicle domain) {
        if (domain == null) return null;

        Long totalTime = null;
        if (domain.getEntryDate() != null && domain.getExitDate() != null) {
            totalTime = Duration.between(domain.getEntryDate(), domain.getExitDate()).toMinutes();
        }

        return VehicleResponse.builder()
                .plate(domain.getPlate())
                .brand(domain.getBrand())
                .model(domain.getModel())
                .ownerName(domain.getOwner().getName())
                .ownerPhone(domain.getOwner().getPhone())
                .serviceType(domain.getService().getType())
                .status(domain.getService().getStatus())
                .entryDate(domain.getEntryDate())
                .exitDate(domain.getExitDate())
                .totalTimeMinutes(totalTime)
                .build();
    }
}
