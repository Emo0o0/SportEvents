package com.example.sportevents.rest.controllers;

import com.example.sportevents.api.inputoutput.sportevent.create.CreateSportEventInput;
import com.example.sportevents.api.inputoutput.sportevent.create.CreateSportEventOperation;
import com.example.sportevents.api.inputoutput.sportevent.create.CreateSportEventOutput;
import com.example.sportevents.api.inputoutput.sportevent.delete.DeleteSportEventInput;
import com.example.sportevents.api.inputoutput.sportevent.delete.DeleteSportEventOperation;
import com.example.sportevents.api.inputoutput.sportevent.delete.DeleteSportEventOutput;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/sportevent")
public class SportEventController {



    private final CreateSportEventOperation createSportEventOperation;
    private final DeleteSportEventOperation deleteSportEventOperation;


    @PostMapping(path = "/create")
    public ResponseEntity<CreateSportEventOutput> createSportEvent(@Valid @RequestBody CreateSportEventInput input){
        return ResponseEntity.status(201).body(createSportEventOperation.process(input));
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<DeleteSportEventOutput> deleteSportEvent(@Valid @RequestBody DeleteSportEventInput input){
        return  ResponseEntity.status(200).body(deleteSportEventOperation.process(input));
    }

}
