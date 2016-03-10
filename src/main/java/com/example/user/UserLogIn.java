package com.example.user;

import org.hibernate.validator.constraints.Email;

/**
 * Created by thoma on 03/10/16.
 */
public class UserLogIn {
    @Email
    public String email;

    public String password;
}
