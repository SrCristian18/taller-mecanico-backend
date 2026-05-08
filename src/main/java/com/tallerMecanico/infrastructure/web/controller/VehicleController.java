package com.tallerMecanico.infrastructure.web.controller;

import com.tallerMecanico.domain.model.ServiceStatus;
import com.tallerMecanico.domain.ports.in.VehicleUseCase;
import com.tallerMecanico.infrastructure.web.dto.VehicleRequest;
import com.tallerMecanico.infrastructure.web.dto.VehicleResponse;
import com.tallerMecanico.infrastructure.web.mappers.VehicleWebMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/vehicles")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class VehicleController {

    private final VehicleUseCase vehicleUseCase;
    private final VehicleWebMapper mapper;

    @PostMapping
    public ResponseEntity<Void> registerVehicle(@RequestBody VehicleRequest request) {
        vehicleUseCase.registerVehicle(mapper.toDomain(request));
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<VehicleResponse>> getAllVehicles() {
        return ResponseEntity.ok(vehicleUseCase.getAllVehicles().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList()));
    }

    @PatchMapping("/{plate}/status")
    public ResponseEntity<Void> updateStatus(@PathVariable String plate, @RequestParam ServiceStatus status) {
        vehicleUseCase.updateStatus(plate, status);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{plate}/finish")
    public ResponseEntity<Void> finishService(@PathVariable String plate) {
        vehicleUseCase.finishService(plate);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/history")
    public ResponseEntity<List<VehicleResponse>> getHistory(
            @RequestParam(required = false) String plate,
            @RequestParam(required = false) String owner) {
        return ResponseEntity.ok(vehicleUseCase.getHistory(plate, owner).stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList()));
    }
}
