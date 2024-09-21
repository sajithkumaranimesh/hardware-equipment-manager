package org.icet.equipmentcrm.controller;

import org.icet.equipmentcrm.dto.Person;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/person")
public class PersonController {

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void persist(@RequestBody Person person){

    }
}
