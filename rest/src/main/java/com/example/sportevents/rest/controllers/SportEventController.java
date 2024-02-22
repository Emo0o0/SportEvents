package com.example.sportevents.rest.controllers;

import com.example.sportevents.api.inputoutput.sportevent.create.CreateSportEventInput;
import com.example.sportevents.api.inputoutput.sportevent.create.CreateSportEventOperation;
import com.example.sportevents.api.inputoutput.sportevent.create.CreateSportEventOutput;
import com.example.sportevents.api.inputoutput.sportevent.delete.DeleteSportEventInput;
import com.example.sportevents.api.inputoutput.sportevent.delete.DeleteSportEventOperation;
import com.example.sportevents.api.inputoutput.sportevent.delete.DeleteSportEventOutput;
import com.example.sportevents.api.inputoutput.sportevent.edit.EditSportEventInput;
import com.example.sportevents.api.inputoutput.sportevent.edit.EditSportEventOperation;
import com.example.sportevents.api.inputoutput.sportevent.edit.EditSportEventOutput;
import com.example.sportevents.api.inputoutput.sportevent.getall.GetAllSportEventsInput;
import com.example.sportevents.api.inputoutput.sportevent.getall.GetAllSportEventsListOutput;
import com.example.sportevents.api.inputoutput.sportevent.getall.GetAllSportEventsOperation;
import com.example.sportevents.api.inputoutput.sportevent.getall.GetAllSportEventsOutput;
import com.example.sportevents.api.inputoutput.sportevent.getbyeventtype.GetSportEventByEventTypeInput;
import com.example.sportevents.api.inputoutput.sportevent.getbyeventtype.GetSportEventByEventTypeListOutput;
import com.example.sportevents.api.inputoutput.sportevent.getbyeventtype.GetSportEventByEventTypeOperation;
import com.example.sportevents.api.inputoutput.sportevent.getbyid.GetSportEventByUUIDInput;
import com.example.sportevents.api.inputoutput.sportevent.getbyid.GetSportEventByUUIDOperation;
import com.example.sportevents.api.inputoutput.sportevent.getbyid.GetSportEventByUUIDOutput;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/sportevent")
public class SportEventController {


    private final CreateSportEventOperation createSportEventOperation;
    private final DeleteSportEventOperation deleteSportEventOperation;
    private final EditSportEventOperation editSportEventOperation;
    private final GetSportEventByUUIDOperation getSportEventByUUIDOperation;
    private final GetSportEventByEventTypeOperation getSportEventByEventTypeOperation;
    private final GetAllSportEventsOperation getAllSportEventsOperation;


    @PostMapping(path = "/create")
    public ResponseEntity<CreateSportEventOutput> createSportEvent(@Valid @RequestBody CreateSportEventInput input) {
        return ResponseEntity.status(201).body(createSportEventOperation.process(input));
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<DeleteSportEventOutput> deleteSportEvent(@Valid @RequestBody DeleteSportEventInput input) {
        return ResponseEntity.status(200).body(deleteSportEventOperation.process(input));
    }

    @PatchMapping(path = "/edit")
    public ResponseEntity<EditSportEventOutput> editSportEvent(@RequestBody EditSportEventInput input) {
        return ResponseEntity.status(200).body(editSportEventOperation.process(input));
    }

    @GetMapping(path = "/getById/{uuid}")
    public ResponseEntity<GetSportEventByUUIDOutput> getSportEvent(@PathVariable String uuid) {
        GetSportEventByUUIDInput input = GetSportEventByUUIDInput.builder().uuid(uuid).build();
        return ResponseEntity.status(200).body(getSportEventByUUIDOperation.process(input));
    }

    @GetMapping(path = "/getByEventType")
    public ResponseEntity<GetSportEventByEventTypeListOutput> getSportEventByEventType(
            @RequestParam String eventType,
            @RequestParam String itemsPerPage,
            @RequestParam String pageNumber) {

        GetSportEventByEventTypeInput input = GetSportEventByEventTypeInput.builder()
                .eventType(eventType)
                .itemsPerPage(itemsPerPage)
                .pageNumber(pageNumber)
                .build();

        return ResponseEntity.status(200).body(getSportEventByEventTypeOperation.process(input));
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<GetAllSportEventsListOutput> getAllSportEvents(
            @RequestParam String itemsPerPage,
            @RequestParam String pageNumber) {

        GetAllSportEventsInput input = GetAllSportEventsInput.builder()
                .itemsPerPage(itemsPerPage)
                .pageNumber(pageNumber)
                .build();

        return ResponseEntity.status(200).body(getAllSportEventsOperation.process(input));
    }

}
