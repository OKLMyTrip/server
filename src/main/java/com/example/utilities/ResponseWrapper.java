package com.example.utilities;

/**
 * Created by thoma on 03/04/16.
 */
public class ResponseWrapper {

    public boolean success;

    public String errorMessage;

    public String message;

    public ResponseWrapper(boolean _success, String _errorMessage, String _message)
    {
        this.success = _success;
        this.errorMessage = _errorMessage;
        this.message = _message;
    }

}
