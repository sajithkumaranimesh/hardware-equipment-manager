package org.icet.equipmentcrm.controller;

import lombok.RequiredArgsConstructor;
import org.icet.equipmentcrm.dto.Notification;
import org.icet.equipmentcrm.service.NotificationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/notification")
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationService service;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void persist(@RequestBody Notification notification){
        service.persist(notification);
    }
}
