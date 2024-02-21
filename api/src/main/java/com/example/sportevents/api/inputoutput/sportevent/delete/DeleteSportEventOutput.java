package com.example.sportevents.api.inputoutput.sportevent.delete;

import com.example.sportevents.api.base.OperationResult;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeleteSportEventOutput implements OperationResult {

    private Boolean success;

}
