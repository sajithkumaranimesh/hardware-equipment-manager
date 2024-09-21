package org.icet.equipmentcrm.controller;

import lombok.RequiredArgsConstructor;
import org.icet.equipmentcrm.dto.Person;
import org.icet.equipmentcrm.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService service;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void persist(@RequestBody Person person){
        service.persist(person);
    }
}
