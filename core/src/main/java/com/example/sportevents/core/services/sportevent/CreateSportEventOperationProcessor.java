package com.example.sportevents.core.services.sportevent;

import com.example.sportevents.api.inputoutput.sportevent.create.CreateSportEventInput;
import com.example.sportevents.api.inputoutput.sportevent.create.CreateSportEventOperation;
import com.example.sportevents.api.inputoutput.sportevent.create.CreateSportEventOutput;
import com.example.sportevents.persistence.entities.EventStatus;
import com.example.sportevents.persistence.entities.EventType;
import com.example.sportevents.persistence.entities.SportEvent;
import com.example.sportevents.persistence.repository.SportEventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@AllArgsConstructor
public class CreateSportEventOperationProcessor implements CreateSportEventOperation {

    private final SportEventRepository sportEventRepository;

    @Override
    public CreateSportEventOutput process(CreateSportEventInput input) {


        SportEvent sportEvent = SportEvent.builder()
                .title(input.getTitle())
                .eventType(EventType.valueOf(input.getEventType()))
                .eventDateAndTime(Timestamp.valueOf(LocalDateTime.from(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm").parse(input.getEventDateAndTime()))))
                .currentStatus(EventStatus.ON_SCHEDULE)
                .matchWonBy(-1)
                .build();

        sportEventRepository.save(sportEvent);

        return CreateSportEventOutput.builder()
                .title(sportEvent.getTitle())
                .eventType(sportEvent.getEventType().toString())
                .eventDateAndTime(sportEvent.getEventDateAndTime().toString())
                .currentStatus(sportEvent.getCurrentStatus().toString())
                .id(sportEvent.getId().toString())
                .success(true)
                .build();

    }
}
