package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello-world")
public class HomeController {


    @Autowired
    private UserRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    String home() {

        repository.deleteAll();

        // save a couple of customers
        repository.save(new User("Alice", "Smith"));
        repository.save(new User("Bob", "Smith"));


        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (User customer : repository.findAll()) {
            System.out.println(customer);
        }
        System.out.println();



        return "homz oklm";
    }

}
