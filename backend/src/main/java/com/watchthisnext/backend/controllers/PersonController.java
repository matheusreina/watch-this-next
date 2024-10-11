package com.watchthisnext.backend.controllers;

import com.watchthisnext.backend.models.person.PersonResponse;
import com.watchthisnext.backend.services.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("{language}/person/{personId}")
    public PersonResponse getPersonDetails(@PathVariable String language, @PathVariable String personId) {
        return personService.getPopularTvs(language, personId);
    }
}
