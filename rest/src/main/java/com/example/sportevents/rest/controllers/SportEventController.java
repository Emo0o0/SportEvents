package com.example.sportevents.rest.controllers;

import com.example.sportevents.api.inputoutput.sportevent.create.CreateSportEventInput;
import com.example.sportevents.api.inputoutput.sportevent.create.CreateSportEventOperation;
import com.example.sportevents.api.inputoutput.sportevent.create.CreateSportEventOutput;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/sportevent")
public class SportEventController {



    private final CreateSportEventOperation createSportEventOperation;


    @PostMapping(path = "/create")
    public ResponseEntity<CreateSportEventOutput> createSportEvent(@Valid @RequestBody CreateSportEventInput input){
        return ResponseEntity.status(200).body(createSportEventOperation.process(input));
    }

}
