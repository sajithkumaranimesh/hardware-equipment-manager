package org.icet.equipmentcrm.service;

import org.icet.equipmentcrm.dto.Notification;

import java.util.List;

public interface NotificationService {
    void persist(Notification notification);

    List<Notification> retrieveAll();

    Notification retrieveById(Long id);

    void update(Notification notification);

    void deleteById(Long id);
}
