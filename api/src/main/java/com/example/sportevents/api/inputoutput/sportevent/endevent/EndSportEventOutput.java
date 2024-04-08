package com.example.sportevents.api.inputoutput.sportevent.endevent;

import com.example.sportevents.api.base.OperationResult;
import lombok.*;


@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EndSportEventOutput implements OperationResult {

    private String id;
    private String title;
    private String eventType;
    private String currentStatus;
    private Integer matchWonBy;

}
