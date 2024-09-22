package org.icet.equipmentcrm.repository;

import org.icet.equipmentcrm.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
}
