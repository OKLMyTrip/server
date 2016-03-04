package com.example.trip;

import com.example.gmap.Leg;
import com.example.gmap.Route;
import com.example.gmap.Step;
import com.example.utilities.DistanceCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
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
    String signIn(@RequestBody Trip trip) {

        repository.save(trip);


        System.out.println("New user signed : " + trip);

        return "OK";
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
}
