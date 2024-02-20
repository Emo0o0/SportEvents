package com.example.sportevents.core.services.sportevent;

import com.example.sportevents.api.inputoutput.sportevent.create.CreateSportEventInput;
import com.example.sportevents.api.inputoutput.sportevent.create.CreateSportEventOperation;
import com.example.sportevents.api.inputoutput.sportevent.create.CreateSportEventOutput;
import com.example.sportevents.persistence.entities.SportEvent;
import com.example.sportevents.persistence.repository.SportEventRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateSportEventOperationProcessor implements CreateSportEventOperation {

    private final SportEventRepository sportEventRepository;

    @Override
    public CreateSportEventOutput process(CreateSportEventInput input) {


        SportEvent sportEvent = SportEvent.builder()
                .title(input.getTitle())
                .build();
        sportEventRepository.save(sportEvent);

        return CreateSportEventOutput.builder()
                .success(true)
                .build();

    }
}
