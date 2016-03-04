package com.example;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by johan on 04/03/2016.
 */
public interface UserRepository extends MongoRepository<User, String> {

    public User findByFirstName(String firstName);

    public List<User> findByLastName(String lastName);


}
