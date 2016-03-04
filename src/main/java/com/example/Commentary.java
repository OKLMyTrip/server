package com.example;

/**
 * Created by thoma on 03/04/16.
 */
public class Commentary {

    public String firstName;
    public String lastName;
    public int rating;
    public String comment;

    Commentary(String _firstName, String _lastName, int _rating, String _comment)
    {
        this.firstName = _firstName;
        this.lastName = _lastName;
        this.rating = _rating;
        this.comment = _comment;
    }
}

