package com.tallerMecanico.infrastructure.persistence.adapters;

import java.util.List;

import org.springframework.stereotype.Component;

import com.tallerMecanico.domain.ports.out.EventHistoryRepositoryPort;
import com.tallerMecanico.infrastructure.persistence.entities.EventHistory;
import com.tallerMecanico.infrastructure.persistence.repositories.EventHistoryJpaRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EventHistoryRepositoryAdapter implements EventHistoryRepositoryPort {
    private final EventHistoryJpaRepository repository;

    @Override
    public List<EventHistory> findAll() {
        return repository.findAll();
    }
  
}
