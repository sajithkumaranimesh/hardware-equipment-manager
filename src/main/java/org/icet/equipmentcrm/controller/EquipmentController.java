package org.icet.equipmentcrm.controller;

import lombok.RequiredArgsConstructor;
import org.icet.equipmentcrm.dto.Equipment;
import org.icet.equipmentcrm.service.EquipmentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
}
