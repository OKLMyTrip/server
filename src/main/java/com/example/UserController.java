package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by thoma on 03/04/16.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository repository;

    @RequestMapping(method = RequestMethod.POST, value = "/sign-in", headers = {"content-type=application/json"})
    public
    @ResponseBody
    ResponseEntity<ResponseWrapper> signIn(@RequestBody User user) {

        repository.save(user);

        System.out.println("New user signed : " + user);

        return new ResponseEntity<ResponseWrapper>(new ResponseWrapper(true, null, "OK"), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/log-in", headers = {"content-type=application/json"})
    public
    @ResponseBody
    String logIn(@RequestBody User user) {

        List<User> users = repository.findAll();

        for ( User reposUser : users ) {


        }

        System.out.println("logged : " + user);

        return "OK";
    }
}
