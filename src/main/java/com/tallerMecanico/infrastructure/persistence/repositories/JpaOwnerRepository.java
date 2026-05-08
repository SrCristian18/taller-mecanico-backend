package com.tallerMecanico.infrastructure.persistence.repositories;

import com.tallerMecanico.infrastructure.persistence.entities.OwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaOwnerRepository extends JpaRepository<OwnerEntity, Long> {
    Optional<OwnerEntity> findByNameAndPhone(String name, String phone);
}
