package org.icet.equipmentcrm.service;

import org.icet.equipmentcrm.dto.Notification;


public interface NotificationService {
    void persist(Notification notification);


    Notification retrieveById(Long id);

    void update(Notification notification);

    void deleteById(Long id);
}
