package com.example.sportevents.api.inputoutput.sportevent.getbyeventtype;

import com.example.sportevents.api.base.OperationResult;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetSportEventByEventTypeOutput {

    private String title;
    private String eventType;
    private String eventDateAndTime;

}
