package com.example.sportevents.core.services.sportevent;

import com.example.sportevents.api.inputoutput.logs.add.AddLogInput;
import com.example.sportevents.api.inputoutput.logs.add.AddLogOperation;
import com.example.sportevents.api.inputoutput.sportevent.delete.DeleteSportEventInput;
import com.example.sportevents.api.inputoutput.sportevent.delete.DeleteSportEventOperation;
import com.example.sportevents.api.inputoutput.sportevent.delete.DeleteSportEventOutput;
import com.example.sportevents.core.exceptions.sportevent.SportEventNotFoundException;
import com.example.sportevents.persistence.entities.SportEvent;
import com.example.sportevents.persistence.repository.SportEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteSportEventOperationProcessor implements DeleteSportEventOperation {

    private final SportEventRepository sportEventRepository;
    private final AddLogOperation addLogOperation;

    @Override
    public DeleteSportEventOutput process(DeleteSportEventInput input) {

        SportEvent sportEvent = sportEventRepository.findById(UUID.fromString(input.getId()))
                .orElseThrow(() -> new SportEventNotFoundException("event not found"));

        sportEventRepository.delete(sportEvent);

        addLogOperation.process(AddLogInput.builder()
                .logMessage("Deleted sport event with:" +
                        "\nid: " + sportEvent.getId().toString() +
                        "\ntitle: " + sportEvent.getTitle() +
                        "\ntype: " + sportEvent.getEventType() +
                        "\ndate: " + sportEvent.getEventDateAndTime() +
                        "\nstatus: " + sportEvent.getCurrentStatus())
                .build());

        return DeleteSportEventOutput.builder()
                .success(true)
                .build();

    }
}
