package com.example.sportevents.api.inputoutput.sportevent.delete;

import com.example.sportevents.api.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeleteSportEventInput implements OperationInput {

    @NotBlank(message = "id cannot be blank")
    private String id;

}
