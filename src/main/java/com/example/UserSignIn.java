package com.example;

import org.hibernate.validator.constraints.Email;

/**
 * Created by thoma on 03/10/16.
 */
public class UserSignIn {
    public String firstName;

    public String lastName;

    @Email
    public String email;

    public String password;

    public String inscriptionDate;
}
