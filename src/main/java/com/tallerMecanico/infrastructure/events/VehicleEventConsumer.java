package com.tallerMecanico.infrastructure.events;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.tallerMecanico.domain.event.VehicleEvent;
import com.tallerMecanico.infrastructure.persistence.entities.EventHistory;
import com.tallerMecanico.infrastructure.persistence.repositories.EventHistoryJpaRepository;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class VehicleEventConsumer {
    
    private final EventHistoryJpaRepository repository;
    
    @PostConstruct
    public void init()
    {
        log.info("*** Vehicle event consume iniciado ***");
    }

    @KafkaListener(
        topics = "vehicle-events",
        groupId = "vehicle-group"
    )

    public void consume(VehicleEvent event)
    {
        log.info("Evento recibido desde kafka -> {}",event);

        EventHistory history = EventHistory.builder()
        .eventType(event.getEventType())
        .vehiclePlate(event.getVehiclePlate())
        .description(event.getDescription())
        .occurredAt(event.getOccurredAt())
        .build();

        repository.save(history);

        log.info("Evento guardado en el historial");
    }
}
