package com.example.trip;

import com.example.gmap.GoogleMapEngine;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * Created by johan on 04/03/2016.
 */
public class Trip {
    @Id
    private String id;

    public String userId;

    public Long date;

    public String dateDeparture;
    public String hoursDeparture;
    public String origin;
    public String destination;

    public GoogleMapEngine googleMapEngine;


}
