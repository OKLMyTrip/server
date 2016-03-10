package com.example.utilities;

import com.example.user.User;

/**
 * Created by thoma on 03/10/16.
 */
public class LoginResponseWrapper {
    public boolean success;

    public String errorMessage;

    public String message;

    public User loggedUser;

    public LoginResponseWrapper(boolean _success, String _errorMessage, String _message, User user)
    {
        this.success = _success;
        this.errorMessage = _errorMessage;
        this.message = _message;
        this.loggedUser = user;
    }
}
