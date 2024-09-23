package org.icet.equipmentcrm.service.impl;

import lombok.RequiredArgsConstructor;
import org.icet.equipmentcrm.dto.Equipment;
import org.icet.equipmentcrm.entity.EquipmentEntity;
import org.icet.equipmentcrm.repository.EquipmentRepository;
import org.icet.equipmentcrm.service.EquipmentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EquipmentServiceImpl implements EquipmentService {

    private final EquipmentRepository repository;

    @Override
    public void persist(Equipment equipment) {
        repository.save(new ModelMapper().map(equipment, EquipmentEntity.class));
    }

    @Override
    public List<Equipment> retrieveAll() {
        List<Equipment> equipmentList = new ArrayList<>();
        List<EquipmentEntity> equipmentEntityList = repository.findAll();
        equipmentEntityList.forEach(equipmentEntity ->
            equipmentList.add(new ModelMapper().map(equipmentEntity, Equipment.class))
        );
        return equipmentList;
    }

    @Override
    public Equipment retrieveById(Long id) {
        Optional<EquipmentEntity> equipmentEntity = repository.findById(id);
        return new ModelMapper().map(equipmentEntity, Equipment.class);
    }

    @Override
    public void update(Equipment equipment) {

    }
}
