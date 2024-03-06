package com.example.sportevents.api.inputoutput.sportevent.getbyid;

import com.example.sportevents.api.base.OperationResult;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetSportEventByUUIDOutput implements OperationResult {

    private String title;
    private String eventType;
    private String eventDateAndTime;
    private String currentStatus;
}
