package com.example.sportevents.core.services.sportevent;

import com.example.sportevents.api.inputoutput.sportevent.delete.DeleteSportEventInput;
import com.example.sportevents.api.inputoutput.sportevent.delete.DeleteSportEventOperation;
import com.example.sportevents.api.inputoutput.sportevent.delete.DeleteSportEventOutput;
import com.example.sportevents.persistence.entities.SportEvent;
import com.example.sportevents.persistence.repository.SportEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteSportEventOperationProcessor implements DeleteSportEventOperation {

    private final SportEventRepository sportEventRepository;

    @Override
    public DeleteSportEventOutput process(DeleteSportEventInput input) {

        SportEvent sportEvent = sportEventRepository.findById(UUID.fromString(input.getId()))
                .orElseThrow(() -> new RuntimeException("user not found"));

        sportEventRepository.delete(sportEvent);

        return DeleteSportEventOutput.builder()
                .success(true)
                .build();

    }
}
