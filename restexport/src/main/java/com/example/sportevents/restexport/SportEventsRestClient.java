package com.example.sportevents.restexport;

import com.example.sportevents.api.inputoutput.sportevent.getbyid.GetSportEventByUUIDOutput;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import jdk.jfr.ContentType;

@Headers({"Content-Type: application/json"})
public interface SportEventsRestClient {

    @RequestLine("GET /sportevent/getById/{uuid}")
    GetSportEventByUUIDOutput getSportEventById(@Param("uuid") String uuid);

}
