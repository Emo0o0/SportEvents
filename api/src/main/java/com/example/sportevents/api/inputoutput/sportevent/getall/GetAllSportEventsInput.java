package com.example.sportevents.api.inputoutput.sportevent.getall;

import com.example.sportevents.api.base.OperationInput;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAllSportEventsInput implements OperationInput {

    private String pageNumber;
    private String itemsPerPage;

}
