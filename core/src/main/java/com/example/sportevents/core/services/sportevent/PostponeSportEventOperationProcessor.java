package com.example.sportevents.core.services.sportevent;

import com.example.sportevents.api.inputoutput.logs.add.AddLogInput;
import com.example.sportevents.api.inputoutput.logs.add.AddLogOperation;
import com.example.sportevents.api.inputoutput.sportevent.postponeevent.PostponeSportEventInput;
import com.example.sportevents.api.inputoutput.sportevent.postponeevent.PostponeSportEventOperation;
import com.example.sportevents.api.inputoutput.sportevent.postponeevent.PostponeSportEventOutput;
import com.example.sportevents.core.exceptions.sportevent.SportEventNotFoundException;
import com.example.sportevents.persistence.entities.EventStatus;
import com.example.sportevents.persistence.entities.SportEvent;
import com.example.sportevents.persistence.repository.SportEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PostponeSportEventOperationProcessor implements PostponeSportEventOperation {

    private final SportEventRepository sportEventRepository;
    private final AddLogOperation addLogOperation;

    @Override
    public PostponeSportEventOutput process(PostponeSportEventInput input) {

        SportEvent sportEvent = sportEventRepository.findById(UUID.fromString(input.getId()))
                .orElseThrow(() -> new SportEventNotFoundException("Not found"));

        sportEvent.setCurrentStatus(EventStatus.POSTPONED);
        sportEventRepository.save(sportEvent);

        addLogOperation.process(AddLogInput.builder()
                .logMessage("Event with id [" + input.getId() + "] was postponed")
                .build());

        return PostponeSportEventOutput.builder()
                .id(sportEvent.getId().toString())
                .title(sportEvent.getTitle())
                .eventType(sportEvent.getEventType().toString())
                .currentStatus(sportEvent.getCurrentStatus().toString())
                .build();


    }
}
