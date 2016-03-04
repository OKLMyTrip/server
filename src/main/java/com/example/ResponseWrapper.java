package com.example;

/**
 * Created by thoma on 03/04/16.
 */
public class ResponseWrapper {

    public boolean success;

    public String errorMessage;

    public String message;

    ResponseWrapper(boolean _success, String _errorMessage, String _message)
    {
        this.success = _success;
        this.errorMessage = _errorMessage;
        this.message = _message;
    }

}
