package com.example.sportevents.core.services.sportevent;

import com.example.sportevents.api.inputoutput.sportevent.getall.GetAllSportEventsInput;
import com.example.sportevents.api.inputoutput.sportevent.getall.GetAllSportEventsListOutput;
import com.example.sportevents.api.inputoutput.sportevent.getall.GetAllSportEventsOperation;
import com.example.sportevents.api.inputoutput.sportevent.getall.GetAllSportEventsOutput;
import com.example.sportevents.persistence.entities.SportEvent;
import com.example.sportevents.persistence.repository.SportEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllSportEventsOperationProcessor implements GetAllSportEventsOperation {

    private final SportEventRepository sportEventRepository;

    @Override
    public GetAllSportEventsListOutput process(GetAllSportEventsInput input) {

        PageRequest pageRequest = PageRequest.of(Integer.parseInt(input.getPageNumber()) - 1, Integer.parseInt(input.getItemsPerPage()));
        List<SportEvent> sportEvents = new ArrayList<>(sportEventRepository.findAll(pageRequest).getContent());

        List<GetAllSportEventsOutput> outputList = new ArrayList<>();
        for (SportEvent se : sportEvents) {

            GetAllSportEventsOutput output = GetAllSportEventsOutput.builder()
                    .title(se.getTitle())
                    .eventType(se.getEventType().toString())
                    .eventDateAndTime(se.getEventDateAndTime().toString())
                    .currentStatus(se.getCurrentStatus().toString())
                    .id(se.getId().toString())
                    .build();
            outputList.add(output);
        }

        return GetAllSportEventsListOutput.builder()
                .sportEvents(outputList)
                .build();

    }
}
