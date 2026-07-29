package org.example._20260729_jpa.controllers;

import org.example._20260729_jpa.models.Person;
import org.example._20260729_jpa.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class PersonController {
    @Autowired
    PersonRepository personRepository;

    //Mondjuk ez belerakja a visszatérésbe a JSON-ba a függvényt + eredményét is.
    @GetMapping("/persons")
    @ResponseBody
    List<Person> getPersons() {
        return personRepository.findAll();
    }
}
