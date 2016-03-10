package com.example.trip;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by johan on 04/03/2016.
 */
public interface TripRepository extends MongoRepository<Trip, String> {

//    public Trip findByFirstName(String firstName);

    public List<Trip> findByDateDeparture(String dateDeparture);

    public List<Trip> findByDateGreaterThan(Long date);


}
