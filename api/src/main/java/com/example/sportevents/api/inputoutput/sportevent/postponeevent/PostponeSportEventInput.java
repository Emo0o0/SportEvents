package com.example.sportevents.api.inputoutput.sportevent.postponeevent;

import com.example.sportevents.api.base.OperationInput;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostponeSportEventInput implements OperationInput {

    private String id;

}
