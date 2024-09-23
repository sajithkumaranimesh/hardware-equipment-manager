package org.icet.equipmentcrm.service;

import org.icet.equipmentcrm.dto.Equipment;

import java.util.List;

public interface EquipmentService {
    void persist(Equipment equipment);

    List<Equipment> retrieveAll();

    Equipment retrieveById(Long id);

    void update(Equipment equipment);

    void deleteById(Long id);
}
