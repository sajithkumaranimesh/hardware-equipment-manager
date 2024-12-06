package org.icet.equipmentcrm.controller;

import lombok.RequiredArgsConstructor;
import org.icet.equipmentcrm.dto.Person;
import org.icet.equipmentcrm.dto.SuccessResponse;
import org.icet.equipmentcrm.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService service;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<SuccessResponse> persist(@RequestBody Person person){
        service.persist(person);
        SuccessResponse successResponse = SuccessResponse.builder()
                .status("SUCCESS")
                .build();
        return ResponseEntity.ok().body(successResponse);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<SuccessResponse> retrieveAll(){
        List<Person> personList = service.retrieveAll();
        SuccessResponse successResponse = SuccessResponse.builder()
                .status("SUCCESS")
                .data(personList)
                .build();
        return ResponseEntity.ok().body(successResponse);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<SuccessResponse> retrieveById(@PathVariable Long id){
        Person person = service.retrieveById(id);
        SuccessResponse successResponse = SuccessResponse.builder()
                .status("SUCCESS")
                .data(person)
                .build();
        return ResponseEntity.ok().body(successResponse);

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody Person person){
        service.update(person);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<SuccessResponse> deleteById(@PathVariable Long id){
        service.deleteById(id);
        SuccessResponse successResponse = SuccessResponse.builder()
                .status("SUCCESS")
                .build();
        return ResponseEntity.ok().body(successResponse);
    }
}
