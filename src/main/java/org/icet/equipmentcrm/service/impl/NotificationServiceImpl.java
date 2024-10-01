package org.icet.equipmentcrm.service.impl;

import lombok.RequiredArgsConstructor;
import org.icet.equipmentcrm.dto.Notification;
import org.icet.equipmentcrm.entity.NotificationEntity;
import org.icet.equipmentcrm.repository.NotificationRepository;
import org.icet.equipmentcrm.service.NotificationService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository repository;


    @Override
    public void persist(Notification notification) {
        repository.save(new ModelMapper().map(notification, NotificationEntity.class));
    }

    @Override
    public List<Notification> retrieveAll() {
        List<Notification> notificationList = new ArrayList<>();
        List<NotificationEntity> notificationEntityList = repository.findAll();
        notificationEntityList.forEach(notificationEntity ->
            notificationList.add(new ModelMapper().map(notificationEntity, Notification.class))
        );
        return notificationList;
    }

    @Override
    public Notification retrieveById(Long id) {
        Optional<NotificationEntity> notificationEntity = repository.findById(id);
        return new ModelMapper().map(notificationEntity, Notification.class);
    }
}
