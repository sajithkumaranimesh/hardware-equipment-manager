package org.icet.equipmentcrm.service;

import org.icet.equipmentcrm.dto.Category;

import java.util.List;

public interface CategoryService {
    void persist(Category category);

    List<Category> retrieveAll(int pageNo, int pageSize);

    Category retrieveById(Long id);

    void update(Category category);

    void deleteById(Long id);

    int retrieveAllCount();
}
