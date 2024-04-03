package com.example.sportevents.core.services.sportevent;

import com.example.sportevents.api.inputoutput.sportevent.getbyeventtype.GetSportEventByEventTypeInput;
import com.example.sportevents.api.inputoutput.sportevent.getbyeventtype.GetSportEventByEventTypeListOutput;
import com.example.sportevents.api.inputoutput.sportevent.getbyeventtype.GetSportEventByEventTypeOperation;
import com.example.sportevents.api.inputoutput.sportevent.getbyeventtype.GetSportEventByEventTypeOutput;
import com.example.sportevents.persistence.entities.EventType;
import com.example.sportevents.persistence.entities.SportEvent;
import com.example.sportevents.persistence.repository.SportEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class GetSportEventByEventTypeOperationProcessor implements GetSportEventByEventTypeOperation {

    private final SportEventRepository sportEventRepository;

    @Override
    public GetSportEventByEventTypeListOutput process(GetSportEventByEventTypeInput input) {

        PageRequest pageRequest = PageRequest.of(Integer.parseInt(input.getPageNumber()) - 1, Integer.parseInt(input.getItemsPerPage()));
        List<SportEvent> sportEvents = new ArrayList<>(sportEventRepository.findSportEventByEventType(EventType.valueOf(input.getEventType()), pageRequest).getContent());

        List<GetSportEventByEventTypeOutput> outputList = new ArrayList<>();
        for (SportEvent se : sportEvents) {
            GetSportEventByEventTypeOutput output = GetSportEventByEventTypeOutput.builder()
                    .title(se.getTitle())
                    .eventType(se.getEventType().toString())
                    .eventDateAndTime(se.getEventDateAndTime().toString())
                    .currentStatus(se.getCurrentStatus().toString())
                    .id(se.getId().toString())
                    .matchWonBy(se.getMatchWonBy().toString())
                    .build();
            outputList.add(output);
        }

        return GetSportEventByEventTypeListOutput.builder()
                .sportEvents(outputList)
                .build();
    }
}
