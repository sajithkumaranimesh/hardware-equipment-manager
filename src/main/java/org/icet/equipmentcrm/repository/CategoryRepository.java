package org.icet.equipmentcrm.repository;

import org.icet.equipmentcrm.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
}
