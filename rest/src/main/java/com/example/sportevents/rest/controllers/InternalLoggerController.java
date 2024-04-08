package com.example.sportevents.rest.controllers;

import com.example.sportevents.api.inputoutput.logs.sendlogs.SendLogsInput;
import com.example.sportevents.api.inputoutput.logs.sendlogs.SendLogsOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
@EnableAsync
@RequiredArgsConstructor
public class InternalLoggerController {

    private final SendLogsOperation sendLogsOperation;

    @Async
    @Scheduled(fixedRate = 60000)
    @PostMapping("/send")
    public void sendLogs() {
        sendLogsOperation.process(new SendLogsInput());
    }

}
