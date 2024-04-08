package com.example.sportevents.core.services.sportevent;

import com.example.sportevents.api.inputoutput.logs.add.AddLogInput;
import com.example.sportevents.api.inputoutput.logs.add.AddLogOperation;
import com.example.sportevents.api.inputoutput.sportevent.edit.EditSportEventInput;
import com.example.sportevents.api.inputoutput.sportevent.edit.EditSportEventOperation;
import com.example.sportevents.api.inputoutput.sportevent.edit.EditSportEventOutput;
import com.example.sportevents.core.exceptions.sportevent.SportEventNotFoundException;
import com.example.sportevents.persistence.entities.EventStatus;
import com.example.sportevents.persistence.entities.EventType;
import com.example.sportevents.persistence.entities.SportEvent;
import com.example.sportevents.persistence.repository.SportEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EditSportEventOperationProcessor implements EditSportEventOperation {

    private final SportEventRepository sportEventRepository;
    private final AddLogOperation addLogOperation;

    @Override
    public EditSportEventOutput process(EditSportEventInput input) {

        SportEvent sportEvent = sportEventRepository.findById(UUID.fromString(input.getUuid()))
                .orElseThrow(() -> new SportEventNotFoundException("Sport event not found"));

        if (!input.getTitle().isBlank()) {
            sportEvent.setTitle(input.getTitle());
        }
        if (!input.getEventType().isBlank()) {
            sportEvent.setEventType(EventType.valueOf(input.getEventType()));
        }
        if (!input.getEventDateAndTime().isBlank()) {
            sportEvent.setEventDateAndTime(Timestamp.valueOf(LocalDateTime.from(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm").parse(input.getEventDateAndTime()))));
        }
        if (!input.getCurrentStatus().isBlank()) {
            sportEvent.setCurrentStatus(EventStatus.valueOf(input.getCurrentStatus()));
        }

        sportEventRepository.save(sportEvent);

        addLogOperation.process(AddLogInput.builder()
                .logMessage("Edited sport event with:" +
                        "\nid: " + sportEvent.getId().toString())
                .build());

        return EditSportEventOutput.builder()
                .title(sportEvent.getTitle())
                .eventType(sportEvent.getEventType().toString())
                .eventDateAndTime(sportEvent.getEventDateAndTime().toString())
                .currentStatus(sportEvent.getCurrentStatus().toString())
                .build();


    }
}
