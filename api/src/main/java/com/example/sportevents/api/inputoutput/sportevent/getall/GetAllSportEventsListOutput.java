package com.example.sportevents.api.inputoutput.sportevent.getall;

import com.example.sportevents.api.base.OperationResult;
import lombok.*;

import java.util.List;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAllSportEventsListOutput implements OperationResult {

    private List<GetAllSportEventsOutput> sportEvents;

}
