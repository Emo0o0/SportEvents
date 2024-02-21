package com.example.sportevents.core.services.sportevent;

import com.example.sportevents.api.inputoutput.sportevent.edit.EditSportEventInput;
import com.example.sportevents.api.inputoutput.sportevent.edit.EditSportEventOperation;
import com.example.sportevents.api.inputoutput.sportevent.edit.EditSportEventOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EditSportEventOperationProcessor implements EditSportEventOperation {



    @Override
    public EditSportEventOutput process(EditSportEventInput input) {
        return null;
    }
}
