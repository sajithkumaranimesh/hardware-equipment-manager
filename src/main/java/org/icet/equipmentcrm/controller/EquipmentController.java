package org.icet.equipmentcrm.controller;

import lombok.RequiredArgsConstructor;
import org.icet.equipmentcrm.dto.Equipment;
import org.icet.equipmentcrm.dto.SuccessResponse;
import org.icet.equipmentcrm.service.EquipmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/equipment")
@RequiredArgsConstructor
public class EquipmentController {

    private final EquipmentService service;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void persist(@RequestBody Equipment equipment){
        service.persist(equipment);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<SuccessResponse> retrieveAll(){
        List<Equipment> equipmentList = service.retrieveAll();
        SuccessResponse successResponse = SuccessResponse.builder()
                .status("SUCCESS")
                .data(equipmentList)
                .build();
        return ResponseEntity.ok().body(successResponse);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<SuccessResponse> retrieveById(@PathVariable Long id){
        Equipment equipment = service.retrieveById(id);
        SuccessResponse successResponse = SuccessResponse.builder()
                .status("SUCCESS")
                .data(equipment)
                .build();
        return ResponseEntity.ok().body(successResponse);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody Equipment equipment){
        service.update(equipment);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id){

        service.deleteById(id);
    }
}
