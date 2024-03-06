package com.example.sportevents.api.inputoutput.sportevent.edit;

import com.example.sportevents.api.base.OperationInput;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EditSportEventInput implements OperationInput {

    private String uuid;
    private String title;
    private String eventType;
    private String currentStatus;
    private String eventDateAndTime;

}
