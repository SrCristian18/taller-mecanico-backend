package com.tallerMecanico.infrastructure.config;

import com.tallerMecanico.application.service.VehicleService;
import com.tallerMecanico.domain.ports.in.VehicleUseCase;
import com.tallerMecanico.domain.ports.out.VehicleRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public VehicleUseCase vehicleUseCase(VehicleRepositoryPort repositoryPort) {
        return new VehicleService(repositoryPort);
    }
}
