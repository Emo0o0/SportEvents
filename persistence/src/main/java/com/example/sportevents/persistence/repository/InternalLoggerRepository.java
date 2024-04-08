package com.example.sportevents.persistence.repository;

import com.example.sportevents.persistence.entities.InternalLogger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InternalLoggerRepository extends JpaRepository<InternalLogger, UUID> {
}
