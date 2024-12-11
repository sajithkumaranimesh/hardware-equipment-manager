package org.icet.equipmentcrm.service.impl;

import lombok.RequiredArgsConstructor;
import org.icet.equipmentcrm.dto.Rental;
import org.icet.equipmentcrm.entity.RentalEntity;
import org.icet.equipmentcrm.repository.EquipmentRepository;
import org.icet.equipmentcrm.repository.PersonRepository;
import org.icet.equipmentcrm.repository.RentalRepository;
import org.icet.equipmentcrm.service.RentalService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService {

    private final RentalRepository repository;
    private final PersonRepository personRepository;
    private final EquipmentRepository equipmentRepository;

    @Override
    public void persist(Rental rental) {
        RentalEntity rentalEntity = new ModelMapper().map(rental, RentalEntity.class);
        rentalEntity.setPerson(personRepository.findByFirstName(rental.getPersonName()).orElse(null));
        rentalEntity.setEquipment(equipmentRepository.findByName(rental.getEquipmentName()).orElse(null));
        rentalEntity.setStartDate(new Date());
        repository.save(rentalEntity);
    }
}
