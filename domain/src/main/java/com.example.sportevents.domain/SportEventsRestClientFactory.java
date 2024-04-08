package com.example.sportevents.domain;

import com.example.sportevents_logger.restexport.SportEventsLoggerRestClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@RequiredArgsConstructor
public class SportEventsRestClientFactory {

    @Bean
    SportEventsLoggerRestClient getRestExportClient(){

        final ObjectMapper objectMapper=new ObjectMapper();
        return Feign.builder()
                .encoder(new JacksonEncoder(objectMapper))
                .decoder(new JacksonDecoder(objectMapper))
                .target(SportEventsLoggerRestClient.class, "http://localhost:8082");
    }

}
