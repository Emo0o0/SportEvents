package com.example.sportevents.api.inputoutput.sportevent.create;

import com.example.sportevents.api.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter (AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateSportEventInput implements OperationInput {

    @NotBlank(message = "title cannot be blank")
    private String title;
    @NotBlank
    private String eventDateAndTime;

}
