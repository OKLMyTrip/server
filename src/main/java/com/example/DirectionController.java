package com.example;

import com.example.gmap.geocode.GoogleMapGeocoding;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by johan on 04/03/2016.
 */

@Controller
@RequestMapping("/direction")
public class DirectionController {


    @RequestMapping(method = RequestMethod.POST)
    public
    @ResponseBody
    String home(@RequestBody GoogleMapGeocoding userLocation) {

        return userLocation.toString();
    }


}
