package com.example.sportevents.api.inputoutput.sportevent.getbyid;

import com.example.sportevents.api.base.OperationInput;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetSportEventByUUIDInput implements OperationInput {

    private String uuid;

}
