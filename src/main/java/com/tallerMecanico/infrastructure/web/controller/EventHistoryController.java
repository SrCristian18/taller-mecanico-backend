package com.tallerMecanico.infrastructure.web.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tallerMecanico.domain.ports.in.EventHistoryUseCase;
import com.tallerMecanico.infrastructure.persistence.entities.EventHistory;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class EventHistoryController {
    private final EventHistoryUseCase service;

    @GetMapping
    public ResponseEntity<List<EventHistory>> getAllEvents() {
        return ResponseEntity.ok(
            service.getAllEvents()
        );
    }

}
