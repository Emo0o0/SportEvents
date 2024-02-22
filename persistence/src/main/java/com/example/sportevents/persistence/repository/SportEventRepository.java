package com.example.sportevents.persistence.repository;

import com.example.sportevents.persistence.entities.EventType;
import com.example.sportevents.persistence.entities.SportEvent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SportEventRepository extends JpaRepository<SportEvent, UUID> {

    Page<SportEvent> findSportEventByEventType(EventType event, Pageable pageable);

}
