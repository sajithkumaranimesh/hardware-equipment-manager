package org.icet.equipmentcrm.controller;

import lombok.RequiredArgsConstructor;
import org.icet.equipmentcrm.dto.Rental;
import org.icet.equipmentcrm.dto.SuccessResponse;
import org.icet.equipmentcrm.service.RentalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/rental")
@RequiredArgsConstructor
public class RentalController {

    private final RentalService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<SuccessResponse> persist(@RequestBody Rental rental){
        service.persist(rental);
        SuccessResponse successResponse = SuccessResponse.builder()
                .status("SUCCESS")
                .build();
        return ResponseEntity.ok().body(successResponse);
    }
}
