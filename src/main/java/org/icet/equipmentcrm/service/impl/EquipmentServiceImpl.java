package org.icet.equipmentcrm.service.impl;

import lombok.RequiredArgsConstructor;
import org.icet.equipmentcrm.dto.Equipment;
import org.icet.equipmentcrm.entity.EquipmentEntity;
import org.icet.equipmentcrm.exception.EquipmentNotFoundException;
import org.icet.equipmentcrm.repository.CategoryRepository;
import org.icet.equipmentcrm.repository.EquipmentRepository;
import org.icet.equipmentcrm.service.EquipmentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EquipmentServiceImpl implements EquipmentService {

    private final EquipmentRepository repository;
    private final CategoryRepository categoryRepository;

    @Override
    public void persist(Equipment equipment) {
        EquipmentEntity equipmentEntity = new ModelMapper().map(equipment, EquipmentEntity.class);
        equipmentEntity.setCategory(categoryRepository.findByName(equipment.getCategoryName()).orElse(null));
        equipmentEntity.setRegisterdDate(new Date());
        repository.save(equipmentEntity);
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
        if (equipmentEntity.isEmpty()){
            throw new EquipmentNotFoundException(String.format("%d No equipment found with this ID",id));
        }
        return new ModelMapper().map(equipmentEntity, Equipment.class);
    }

    @Override
    public void update(Equipment equipment) {
        EquipmentEntity equipmentEntity = new ModelMapper().map(equipment, EquipmentEntity.class);
        if (repository.findById(equipment.getId()).isEmpty()){
            throw new EquipmentNotFoundException(String.format("%s This equipment not found",equipment));
        }
        repository.save(equipmentEntity);
    }

    @Override
    public void deleteById(Long id) {
        if (repository.findById(id).isEmpty()){
            throw new EquipmentNotFoundException(String.format("%d No equipment found with this ID",id));
        }
        repository.deleteById(id);
    }
}
