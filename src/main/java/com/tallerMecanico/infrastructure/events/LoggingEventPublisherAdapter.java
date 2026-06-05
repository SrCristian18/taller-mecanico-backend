package com.tallerMecanico.infrastructure.events;

import org.springframework.stereotype.Component;

import com.tallerMecanico.domain.event.VehicleEvent;
import com.tallerMecanico.domain.ports.out.EventPublisherPort;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Slf4j
// @Component
public class LoggingEventPublisherAdapter implements EventPublisherPort{

    @Override
    public void publish(VehicleEvent event) {
        log.info("Evento generado -> {}",event);
    }

    @PostConstruct
    public void init() {
    log.info("LoggingEventPublisherAdapter cargado");
}

}