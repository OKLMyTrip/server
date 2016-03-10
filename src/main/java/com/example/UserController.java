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

    @RequestMapping(method = RequestMethod.POST, value = "/sign-up", headers = {"content-type=application/json"})
    public
    @ResponseBody
    ResponseEntity<ResponseWrapper> signIn(@RequestBody UserSignIn user) {

        List<User> users = repository.findAll();
        boolean email_already_registered = false;

        for (User reposUser : users)
        {
            if(reposUser.email.equals(user.email))
            {
                email_already_registered = true;
                break;
            }
        }
        if(!email_already_registered)
        {
            User newUser = repository.save(new User(user));

            System.out.println("New user signed : " + newUser);

            return new ResponseEntity<ResponseWrapper>(new ResponseWrapper(true, null, "USER_SIGNED"), HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<ResponseWrapper>(new ResponseWrapper(false, null, "USER_MAIL_ALREADY_USED"), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/log-in", headers = {"content-type=application/json"})
    public
    @ResponseBody
    ResponseEntity<ResponseWrapper> logIn(@RequestBody UserLogIn user) {

        List<User> users = repository.findAll();
        boolean userIdentified = false;
        boolean passIdentified = false;

        for ( User reposUser : users ) {
            if(reposUser.email.equals(user.email))
            {
                if(reposUser.password.equals(user.password))
                {
                    userIdentified = true;
                    break;
                }
            }

        }

        if(userIdentified)
        {
            System.out.println("logged : " + user);
            return new ResponseEntity<ResponseWrapper>(new ResponseWrapper(true, null, "USER_LOGGED"), HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<ResponseWrapper>(new ResponseWrapper(false, null, "USER_WRONG_CREDENTIALS"), HttpStatus.FORBIDDEN);
        }

    }

    @RequestMapping(method = RequestMethod.POST, value = "/edit", headers = {"content-type=application/json"})
    public
    @ResponseBody
    ResponseEntity<ResponseWrapper> editProfile(@RequestBody User user) {
        try
        {
            User userInDb = repository.findOne(user.id);
            userInDb.updateEditable(user);
            repository.save(userInDb);
        }
        catch (Exception ex)
        {
            return new ResponseEntity<ResponseWrapper>(new ResponseWrapper(false, null, "USER_UNKNOWN_ERROR"), HttpStatus.CONFLICT);
        }

        return new ResponseEntity<ResponseWrapper>(new ResponseWrapper(true, null, "USER_EDITED"), HttpStatus.OK);
    }
}
