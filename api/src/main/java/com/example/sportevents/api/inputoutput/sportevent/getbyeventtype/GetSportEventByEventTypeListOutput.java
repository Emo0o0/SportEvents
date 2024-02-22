package com.example.sportevents.api.inputoutput.sportevent.getbyeventtype;

import com.example.sportevents.api.base.OperationResult;
import lombok.*;

import java.util.List;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetSportEventByEventTypeListOutput implements OperationResult {

    private List<GetSportEventByEventTypeOutput> sportEvents;

}
