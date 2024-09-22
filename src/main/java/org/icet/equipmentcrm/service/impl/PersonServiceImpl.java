package org.icet.equipmentcrm.service.impl;

import lombok.RequiredArgsConstructor;
import org.icet.equipmentcrm.dto.Person;
import org.icet.equipmentcrm.entity.PersonEntity;
import org.icet.equipmentcrm.repository.PersonRepository;
import org.icet.equipmentcrm.service.PersonService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repository;

    @Override
    public void persist(Person person) {
        repository.save(new ModelMapper().map(person, PersonEntity.class));
    }

    @Override
    public List<Person> retrieveAll() {
        List<Person> personList = new ArrayList<>();
        List<PersonEntity> personEntityList = repository.findAll();
        personEntityList.forEach(personEntity ->
            personList.add(new ModelMapper().map(personEntity, Person.class))
        );
        return personList;
    }

    @Override
    public Person retrieveById(Long id) {
        return new ModelMapper().map(repository.findById(id), Person.class);
    }

    @Override
    public void update(Person person) {
        if (repository.findById(person.getId()).isPresent()){
            repository.save(new ModelMapper().map(person, PersonEntity.class));
        }
    }

    @Override
    public void deleteById(Long id) {
        if (repository.findById(id).isPresent()){
            repository.deleteById(id);
        }
    }
}
