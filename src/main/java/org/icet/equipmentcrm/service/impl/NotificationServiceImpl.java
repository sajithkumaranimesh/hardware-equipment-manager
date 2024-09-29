package org.icet.equipmentcrm.service.impl;

import lombok.RequiredArgsConstructor;
import org.icet.equipmentcrm.dto.Notification;
import org.icet.equipmentcrm.entity.NotificationEntity;
import org.icet.equipmentcrm.repository.NotificationRepository;
import org.icet.equipmentcrm.service.NotificationService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository repository;


    @Override
    public void persist(Notification notification) {
        repository.save(new ModelMapper().map(notification, NotificationEntity.class));
    }
}
