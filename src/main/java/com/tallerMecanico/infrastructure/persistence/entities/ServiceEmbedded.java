package com.tallerMecanico.infrastructure.persistence.entities;

import com.tallerMecanico.domain.model.ServiceStatus;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceEmbedded {
    private String type;
    
    @Enumerated(EnumType.STRING)
    private ServiceStatus status;
}
