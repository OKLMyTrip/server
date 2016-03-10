package com.example;

import com.example.gmap.GoogleMapEngine;
import com.example.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello-world")
public class HomeController {


    @Autowired
    private UserRepository repository;

    @RequestMapping(method = RequestMethod.POST)
    public
    @ResponseBody
    String home(@RequestBody GoogleMapEngine map) {


        return map.toString();
    }

}
