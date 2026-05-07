package com.tallerMecanico.infrastructure.adapter.in;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tallerMecanico.domain.model.Vehicle;
import com.tallerMecanico.domain.ports.in.VehicleUseCase;

@RestController
@RequestMapping("/vehicles")
@CrossOrigin("*")
public class VehicleController {
    private final VehicleUseCase useCase;

    public VehicleController(VehicleUseCase usecase)
    {
        super();
        this.useCase = usecase;
    }
    
    @PostMapping
    public void create(@RequestBody Vehicle vehicle)
    {
        useCase.registerVehicle(vehicle);
    }

    @GetMapping
    public List<Vehicle> getAll(){
        return useCase.getAllVehicles()
        .stream().toList();
    }
}
