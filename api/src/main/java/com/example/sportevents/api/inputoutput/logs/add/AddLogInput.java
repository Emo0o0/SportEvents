package com.example.sportevents.api.inputoutput.logs.add;

import com.example.sportevents.api.base.OperationInput;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddLogInput implements OperationInput {

    private String logMessage;

}
