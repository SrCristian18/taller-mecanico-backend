package com.tallerMecanico.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tallerMecanico.domain.ports.in.EventHistoryUseCase;
import com.tallerMecanico.domain.ports.out.EventHistoryRepositoryPort;
import com.tallerMecanico.infrastructure.persistence.entities.EventHistory;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventHistoryService implements EventHistoryUseCase {
    private final EventHistoryRepositoryPort repositoryPort;

    @Override
    public List<EventHistory> getAllEvents() {
        return repositoryPort.findAll();
    }
}
