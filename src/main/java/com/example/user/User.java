package com.example.user;

import org.hibernate.validator.constraints.Email;
import org.springframework.data.annotation.Id;

/**
 * Created by johan on 04/03/2016.
 */
public class User {
    @Id
    public String id;

    public String firstName;

    public String lastName;

    @Email
    public String email;

    public String password;

    public String carBrand;

    public int carPlaces;

    public boolean smoker;

    public String inscriptionDate;

    public int music;

    public boolean animals;

    public int announcesCount;

    public User() {}

    public User(String _firstName, String _lastName, String _email, String _password,
                String _carBrand, int _carPlaces,
                boolean _smoker, String _inscriptionDate, int _music, boolean _animals, int _announcesCount)
    {
        this.firstName = _firstName;
        this.lastName = _lastName;
        this.email = _email;
        this.password = _password;
        this.carBrand = _carBrand;
        this.carPlaces = _carPlaces;
        this.smoker = _smoker;
        this.inscriptionDate = _inscriptionDate;
        this.music = _music;
        this.animals = _animals;
        this.announcesCount = _announcesCount;
    }

    public User(UserSignIn user)
    {
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.email = user.email;
        this.password = user.password;
        this.inscriptionDate = user.inscriptionDate;
    }

    public void updateEditable(String _firstName, String _lastName, String _email, String _password,
                               String _carBrand, int _carPlaces,
                               boolean _smoker, int _music, boolean _animals)
    {
        this.firstName = _firstName;
        this.lastName = _lastName;
        this.email = _email;
        this.password = _password;
        this.carBrand = _carBrand;
        this.carPlaces = _carPlaces;
        this.smoker = _smoker;
        this.music = _music;
        this.animals = _animals;
    }

    public void updateEditable(User user)
    {
        if(user.firstName != null)
            this.firstName = user.firstName;

        if(user.lastName != null)
            this.lastName = user.lastName;

        if(user.email != null)
            this.email = user.email;

        if(user.password != null)
            this.password = user.password;

        if(user.carBrand != null)
            this.carBrand = user.carBrand;

        this.carPlaces = user.carPlaces;
        this.smoker = user.smoker;

        if(user.inscriptionDate != null)
            this.inscriptionDate = user.inscriptionDate;

        this.music = user.music;
        this.animals = user.animals;
        this.announcesCount = user.announcesCount;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, firstName='%s', lastName='%s', email='%s', carBrand='%s', carPlaces='%d', smoker='%b', inscriptionDate='%s', music='%d', animals='%b', announces='%d']",
                id, firstName, lastName, email, carBrand, carPlaces, smoker, inscriptionDate, music, animals, announcesCount);
    }

}
