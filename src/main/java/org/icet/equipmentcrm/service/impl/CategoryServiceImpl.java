package org.icet.equipmentcrm.service.impl;

import lombok.RequiredArgsConstructor;
import org.icet.equipmentcrm.dto.Category;
import org.icet.equipmentcrm.entity.CategoryEntity;
import org.icet.equipmentcrm.repository.CategoryRepository;
import org.icet.equipmentcrm.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    @Override
    public void persist(Category category) {
        repository.save(new ModelMapper().map(category, CategoryEntity.class));
    }
}
