package com.example.sportevents.api.inputoutput.sportevent.getbyeventtype;

import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetSportEventByEventTypeOutput {

    private String title;
    private String eventType;
    private String eventDateAndTime;
    private String currentStatus;
    private String id;
    private String matchWonBy;

}
