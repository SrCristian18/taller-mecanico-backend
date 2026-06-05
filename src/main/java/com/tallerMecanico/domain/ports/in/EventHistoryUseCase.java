package com.tallerMecanico.domain.ports.in;

import java.util.List;

import com.tallerMecanico.infrastructure.persistence.entities.EventHistory;

public interface EventHistoryUseCase {
    List<EventHistory> getAllEvents();
}
