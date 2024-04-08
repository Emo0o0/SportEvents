package com.example.sportevents.api.inputoutput.logs.add;

import com.example.sportevents.api.base.OperationResult;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddLogOutput implements OperationResult {

    private String id;
    private String logMessage;
    private String timestamp;

}
