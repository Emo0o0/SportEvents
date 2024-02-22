package com.example.sportevents.api.inputoutput.sportevent.getbyeventtype;

import com.example.sportevents.api.base.OperationInput;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetSportEventByEventTypeInput implements OperationInput {

    private String eventType;
    private String pageNumber;
    private String itemsPerPage;

}
