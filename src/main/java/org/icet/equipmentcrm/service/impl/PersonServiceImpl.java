package org.icet.equipmentcrm.service.impl;

import lombok.RequiredArgsConstructor;
import org.icet.equipmentcrm.dto.Person;
import org.icet.equipmentcrm.entity.PersonEntity;
import org.icet.equipmentcrm.repository.PersonRepository;
import org.icet.equipmentcrm.service.PersonService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repository;

    @Override
    public void persist(Person person) {
        repository.save(new ModelMapper().map(person, PersonEntity.class));
    }
}
