package com.tallerMecanico.domain.ports.out;

import java.util.List;

import com.tallerMecanico.infrastructure.persistence.entities.EventHistory;

public interface EventHistoryRepositoryPort {
    List<EventHistory> findAll();
}
