package com.tallerMecanico.infrastructure.events;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.tallerMecanico.domain.event.VehicleEvent;
import com.tallerMecanico.domain.ports.out.EventPublisherPort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class KafkaEventPublisherAdapter implements EventPublisherPort{
    private final KafkaTemplate<String, VehicleEvent> kafkaTemplate;
    
    @Override
    public void publish(VehicleEvent event) {
        kafkaTemplate.send("vehicle-events", 
        event.getVehiclePlate(),
        event);
    }
}