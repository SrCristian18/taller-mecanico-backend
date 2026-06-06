package com.tallerMecanico.infrastructure.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tallerMecanico.infrastructure.persistence.entities.EventHistory;

public interface EventHistoryJpaRepository extends JpaRepository<EventHistory, Long> {
    
}
