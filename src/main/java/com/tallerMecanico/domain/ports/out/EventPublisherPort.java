package com.tallerMecanico.domain.ports.out;

import com.tallerMecanico.domain.event.VehicleEvent;

public interface EventPublisherPort {

    void publish(VehicleEvent event);

}