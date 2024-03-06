package com.example.sportevents.api.inputoutput.sportevent.getall;

import com.example.sportevents.api.base.OperationResult;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAllSportEventsOutput implements OperationResult {

    private String title;
    private String eventType;
    private String eventDateAndTime;
    private String currentStatus;
    private String id;

}
