package com.example.user;

import com.example.utilities.LoginResponseWrapper;
import com.example.utilities.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by thoma on 03/04/16.
 */

@Controller
@RequestMapping("/api/user")
public class UserController {


    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public
    @ResponseBody
    ResponseEntity<List<User>> list() {

        List<User> users = repository.findAll();

        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @Autowired
    private UserRepository repository;


    @RequestMapping(method = RequestMethod.POST, value = "/sign-up", headers = {"content-type=application/json"})
    public
    @ResponseBody
    ResponseEntity<ResponseWrapper> signIn(@RequestBody UserSignIn user) {

        List<User> users = repository.findAll();
        boolean email_already_registered = false;

        for (User reposUser : users) {
            if (reposUser.email.equals(user.email)) {
                email_already_registered = true;
                break;
            }
        }
        if (!email_already_registered) {
            User newUser = repository.save(new User(user));

            System.out.println("New user signed : " + newUser);

            return new ResponseEntity<ResponseWrapper>(new ResponseWrapper(true, null, "USER_SIGNED"), HttpStatus.OK);
        } else {
            return new ResponseEntity<ResponseWrapper>(new ResponseWrapper(false, null, "USER_MAIL_ALREADY_USED"), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/log-in", headers = {"content-type=application/json"})
    public
    @ResponseBody
    ResponseEntity<LoginResponseWrapper> logIn(@RequestBody UserLogIn user) {

        List<User> users = repository.findAll();
        boolean userIdentified = false;
        boolean passIdentified = false;
        User loggedUser = null;

        for (User reposUser : users) {
            if (reposUser.email.equals(user.email)) {
                if (reposUser.password.equals(user.password)) {
                    userIdentified = true;
                    loggedUser = reposUser;
                    break;
                }
            }

        }

        if (userIdentified) {
            System.out.println("logged : " + loggedUser);
            return new ResponseEntity<LoginResponseWrapper>(new LoginResponseWrapper(true, null, "USER_LOGGED", loggedUser), HttpStatus.OK);
        } else {
            return new ResponseEntity<LoginResponseWrapper>(new LoginResponseWrapper(false, null, "USER_WRONG_CREDENTIALS", null), HttpStatus.FORBIDDEN);
        }

    }

    @RequestMapping(method = RequestMethod.POST, value = "/edit", headers = {"content-type=application/json"})
    public
    @ResponseBody
    ResponseEntity<ResponseWrapper> editProfile(@RequestBody User user) {
        try {
            User userInDb = repository.findOne(user.id);
            userInDb.updateEditable(user);
            repository.save(userInDb);
        } catch (Exception ex) {
            return new ResponseEntity<ResponseWrapper>(new ResponseWrapper(false, null, "USER_UNKNOWN_ERROR"), HttpStatus.CONFLICT);
        }

        return new ResponseEntity<ResponseWrapper>(new ResponseWrapper(true, null, "USER_EDITED"), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, headers = {"content-type=application/json"})
    public
    @ResponseBody
    ResponseEntity<User> getUser(@RequestParam String userId) {

        User userInDb = repository.findOne(userId);

        return new ResponseEntity<User>(userInDb, HttpStatus.OK);
    }

}
