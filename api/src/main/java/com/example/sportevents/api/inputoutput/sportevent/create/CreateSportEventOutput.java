package com.example.sportevents.api.inputoutput.sportevent.create;

import com.example.sportevents.api.base.OperationResult;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateSportEventOutput implements OperationResult {

    private String title;
    private String eventType;
    private String eventDateAndTime;
    private Boolean success;
}
