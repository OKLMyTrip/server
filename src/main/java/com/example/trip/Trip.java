package com.example.trip;

import com.example.gmap.GoogleMapEngine;
import org.springframework.data.annotation.Id;

/**
 * Created by johan on 04/03/2016.
 */
public class Trip {
    @Id
    private String id;

    public String userId;

    public String dateDeparture;
    public String origin;
    public String destination;

    public GoogleMapEngine googleMapEngine;


}
