package org.icet.equipmentcrm.service;

import org.icet.equipmentcrm.dto.Person;

import java.util.List;

public interface PersonService {
    void persist(Person person);

    List<Person> retrieveAll();

    Person retrieveById(Long id);

    void update(Person person);
}
