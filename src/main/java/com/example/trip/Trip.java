package com.example.trip;

import com.example.user.User;
import com.example.gmap.GoogleMapEngine;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by johan on 04/03/2016.
 */
public class Trip {
    @Id
    public String id;

    public String userId;

    public Long date;

    public List<String> usersSubscribed;

    public String dateDeparture;
    public String hoursDeparture;
    public String origin;
    public String destination;
    public int price;
    public int placesLeft;
    public User user;

    public GoogleMapEngine googleMapEngine;

    Trip()
    {
        usersSubscribed = new ArrayList<>();
    }
}
