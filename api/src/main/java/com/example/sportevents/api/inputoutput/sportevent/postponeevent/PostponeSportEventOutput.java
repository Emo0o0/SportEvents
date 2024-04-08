package com.example.sportevents.api.inputoutput.sportevent.postponeevent;

import com.example.sportevents.api.base.OperationResult;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostponeSportEventOutput implements OperationResult {

    private String id;
    private String title;
    private String eventType;
    private String currentStatus;

}
