package org.icet.equipmentcrm.service.impl;

import lombok.RequiredArgsConstructor;
import org.icet.equipmentcrm.dto.Equipment;
import org.icet.equipmentcrm.entity.EquipmentEntity;
import org.icet.equipmentcrm.repository.EquipmentRepository;
import org.icet.equipmentcrm.service.EquipmentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EquipmentServiceImpl implements EquipmentService {

    private final EquipmentRepository repository;

    @Override
    public void persist(Equipment equipment) {
        repository.save(new ModelMapper().map(equipment, EquipmentEntity.class));
    }
}
