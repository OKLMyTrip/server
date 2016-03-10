package com.example.trip;

import com.example.user.User;
import com.example.utilities.ResponseWrapper;
import com.example.gmap.Leg;
import com.example.gmap.Route;
import com.example.gmap.Step;
import com.example.utilities.DistanceCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by thoma on 03/04/16.
 */

@Controller
@RequestMapping("/trip")
public class TripController {

    @Autowired
    private TripRepository repository;

    @RequestMapping(method = RequestMethod.POST, value = "/create", headers = {"content-type=application/json"})
    public
    @ResponseBody
    ResponseEntity<ResponseWrapper> proposeTrip(@RequestBody Trip trip) {

        repository.save(trip);


//        System.out.println("New trip created : " + trip);

        return new ResponseEntity<ResponseWrapper>(new ResponseWrapper(true, null, "TRIP_CREATED"), HttpStatus.OK);

    }


    @RequestMapping(method = RequestMethod.POST, value = "/find", headers = {"content-type=application/json"})
    public
    @ResponseBody
    List<Trip> find(@RequestBody TripResearch tripResearch) {


        Long timeToResearch = new Long(tripResearch.date);

        List<Trip> tripDateFound = repository.findByDateGreaterThan(timeToResearch);


        ArrayList<Trip> tripNearest = new ArrayList<Trip>();

        double mPrecision = 2.00;

        if (tripResearch.precision == 0.0) {
            mPrecision = 2.00;
        } else {
            mPrecision = tripResearch.precision;
        }


        for (Trip trip : tripDateFound) {

            boolean tripDepartureAdded = false;
            boolean tripArrivedAdded = false;

            Route currentRoute = trip.googleMapEngine.getRoutes().get(0);

            ArrayList<Leg> legs = (ArrayList<Leg>) currentRoute.getLegs();


            for (Leg leg : legs) {

                ArrayList<Step> steps = (ArrayList<Step>) leg.getSteps();

                for (Step step : steps) {

                    if (tripDepartureAdded) {
                        double distance = DistanceCalculator.distance(
                                step.getStartLocation().getLat(),
                                step.getStartLocation().getLng(),
                                tripResearch.destinationLocation.getResults().get(0).getGeometry().getLocation().getLat(),
                                tripResearch.destinationLocation.getResults().get(0).getGeometry().getLocation().getLng(),
                                "M");

                        if (distance <= mPrecision) {
                            if (!tripArrivedAdded) {
                                tripNearest.add(trip);
                                tripArrivedAdded = true;
                            }
                        }
                    } else {
                        double distance = DistanceCalculator.distance(
                                step.getStartLocation().getLat(),
                                step.getStartLocation().getLng(),
                                tripResearch.originLocation.getResults().get(0).getGeometry().getLocation().getLat(),
                                tripResearch.originLocation.getResults().get(0).getGeometry().getLocation().getLng(),
                                "M");

                        if (distance <= mPrecision) {
                            if (!tripDepartureAdded) {
//                                tripNearest.add(trip);
                                tripDepartureAdded = true;
                            }
                        }
                    }


                }
            }

        }


        return tripNearest;

    }


    @RequestMapping(method = RequestMethod.POST, value = "/subscribe", headers = {"content-type=application/json"})
    public
    @ResponseBody
    ResponseEntity<ResponseWrapper> subscribe(@RequestBody TripSubscription sub) {

        try {
            Trip trip = repository.findOne(sub.tripId);

            if(trip.usersSubscribed == null) trip.usersSubscribed = new ArrayList<>();

            trip.usersSubscribed.add(sub.userId);

            repository.save(trip);
        }
        catch (Exception ex)
        {
            return new ResponseEntity<ResponseWrapper>(new ResponseWrapper(false, null, "TRIP_SUBSCRIPTION_ERROR"), HttpStatus.FORBIDDEN);
        }


        return new ResponseEntity<ResponseWrapper>(new ResponseWrapper(true, null, "TRIP_SUBSCRIBED"), HttpStatus.OK);

    }

}
