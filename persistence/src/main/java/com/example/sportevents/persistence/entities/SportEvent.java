package com.example.sportevents.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SportEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;
    @Enumerated(EnumType.STRING)
    private EventType eventType;
    private EventStatus currentStatus;
    private Timestamp eventDateAndTime;
    private String notificationMessage;
}
