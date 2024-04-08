package com.example.sportevents.core.services.logger;

import com.example.sportevents.api.inputoutput.logs.add.AddLogInput;
import com.example.sportevents.api.inputoutput.logs.add.AddLogOperation;
import com.example.sportevents.api.inputoutput.logs.add.AddLogOutput;
import com.example.sportevents.persistence.entities.InternalLogger;
import com.example.sportevents.persistence.repository.InternalLoggerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddLogOperationProcessor implements AddLogOperation {

    private final InternalLoggerRepository internalLoggerRepository;

    @Override
    public AddLogOutput process(AddLogInput input) {

        InternalLogger log = InternalLogger.builder()
                .logMessage(input.getLogMessage())
                .build();

        internalLoggerRepository.save(log);



        return AddLogOutput.builder()
                .id(log.getId().toString())
                .logMessage(log.getLogMessage())
                .timestamp(log.getTimestamp().toString())
                .build();

    }
}
