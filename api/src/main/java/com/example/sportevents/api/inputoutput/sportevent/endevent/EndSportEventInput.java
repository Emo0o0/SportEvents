package com.example.sportevents.api.inputoutput.sportevent.endevent;

import com.example.sportevents.api.base.OperationInput;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EndSportEventInput implements OperationInput {

    private String id;
    private String matchWonBy;

}
