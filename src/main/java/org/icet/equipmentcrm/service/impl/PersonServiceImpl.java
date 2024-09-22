package org.icet.equipmentcrm.service.impl;

import lombok.RequiredArgsConstructor;
import org.icet.equipmentcrm.dto.Person;
import org.icet.equipmentcrm.entity.PersonEntity;
import org.icet.equipmentcrm.exception.PersonNotFoundException;
import org.icet.equipmentcrm.repository.PersonRepository;
import org.icet.equipmentcrm.service.PersonService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        Optional<PersonEntity> personEntity = repository.findById(id);
        if (personEntity.isEmpty())
            throw new PersonNotFoundException(String.format("%d No person found with this ID",id));
        return new ModelMapper().map(personEntity, Person.class);
    }

    @Override
    public void update(Person person) {
        PersonEntity personEntity = new ModelMapper().map(person, PersonEntity.class);
        if (repository.findById(person.getId()).isEmpty()){
            throw new PersonNotFoundException(String.format("%s This person not found",person));
        }
        repository.save(personEntity);
    }

    @Override
    public void deleteById(Long id) {
        if (repository.findById(id).isPresent()){
            repository.deleteById(id);
        }
    }
}
