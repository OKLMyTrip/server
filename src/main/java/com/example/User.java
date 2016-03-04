package com.example;

import org.springframework.data.annotation.Id;

/**
 * Created by johan on 04/03/2016.
 */
public class User {
    @Id
    private String id;

    private String firstName;
    private String lastName;
    public String email;
    public String password;

    public User() {}

    public User(String _firstName, String _lastName, String _email, String _password) {
        this.firstName = _firstName;
        this.lastName = _lastName;
        this.email = _email;
        this.password = _password;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, firstName='%s', lastName='%s', email='%s']",
                id, firstName, lastName, email);
    }

}
