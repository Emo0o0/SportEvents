package com.example.sportevents.core.services.sportevent;

import com.example.sportevents.api.inputoutput.sportevent.getbyid.GetSportEventByUUIDInput;
import com.example.sportevents.api.inputoutput.sportevent.getbyid.GetSportEventByUUIDOperation;
import com.example.sportevents.api.inputoutput.sportevent.getbyid.GetSportEventByUUIDOutput;
import com.example.sportevents.core.exceptions.SportEventNotFoundException;
import com.example.sportevents.persistence.entities.SportEvent;
import com.example.sportevents.persistence.repository.SportEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetSportEventByUUIDOperationProcessor implements GetSportEventByUUIDOperation {

    private final SportEventRepository sportEventRepository;

    @Override
    public GetSportEventByUUIDOutput process(GetSportEventByUUIDInput input) {

        SportEvent sportEvent = sportEventRepository.findById(UUID.fromString(input.getUuid()))
                .orElseThrow(() -> new SportEventNotFoundException("Sport event not found"));

        return GetSportEventByUUIDOutput.builder()
                .title(sportEvent.getTitle())
                .eventType(sportEvent.getEventType().toString())
                .eventDateAndTime(sportEvent.getEventDateAndTime().toString())
                .currentStatus(sportEvent.getCurrentStatus().toString())
                .build();

    }
}
