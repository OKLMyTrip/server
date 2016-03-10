package com.example.trip;

import com.example.User;
import com.example.gmap.GoogleMapEngine;
import org.springframework.data.annotation.Id;

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
    public int price;
    public User user;

    public GoogleMapEngine googleMapEngine;


}
