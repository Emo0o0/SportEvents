package com.example.sportevents.core.services.sportevent;

import com.example.sportevents.api.inputoutput.logs.add.AddLogInput;
import com.example.sportevents.api.inputoutput.logs.add.AddLogOperation;
import com.example.sportevents.api.inputoutput.sportevent.endevent.EndSportEventInput;
import com.example.sportevents.api.inputoutput.sportevent.endevent.EndSportEventOperation;
import com.example.sportevents.api.inputoutput.sportevent.endevent.EndSportEventOutput;
import com.example.sportevents.core.exceptions.sportevent.SportEventNotFoundException;
import com.example.sportevents.persistence.entities.EventStatus;
import com.example.sportevents.persistence.entities.SportEvent;
import com.example.sportevents.persistence.repository.SportEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EndSportEventOperationProcessor implements EndSportEventOperation {

    private final SportEventRepository sportEventRepository;
    private final AddLogOperation addLogOperation;

    @Override
    public EndSportEventOutput process(EndSportEventInput input) {

        SportEvent sportEvent = sportEventRepository.findById(UUID.fromString(input.getId()))
                .orElseThrow(() -> new SportEventNotFoundException("Not found"));

        sportEvent.setMatchWonBy(Integer.parseInt(input.getMatchWonBy()));
        sportEvent.setCurrentStatus(EventStatus.ENDED);

        sportEventRepository.save(sportEvent);

        addLogOperation.process(AddLogInput.builder()
                .logMessage("Event with id [" + input.getId() + "] was ended")
                .build());

        return EndSportEventOutput.builder()
                .id(sportEvent.getId().toString())
                .title(sportEvent.getTitle())
                .eventType(sportEvent.getEventType().toString())
                .currentStatus(sportEvent.getCurrentStatus().toString())
                .matchWonBy(sportEvent.getMatchWonBy())
                .build();

    }
}
