package org.icet.equipmentcrm.service.impl;

import lombok.RequiredArgsConstructor;
import org.icet.equipmentcrm.dto.Category;
import org.icet.equipmentcrm.entity.CategoryEntity;
import org.icet.equipmentcrm.exception.CategoryNotFoundException;
import org.icet.equipmentcrm.repository.CategoryRepository;
import org.icet.equipmentcrm.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    @Override
    public void persist(Category category) {
        repository.save(new ModelMapper().map(category, CategoryEntity.class));
    }

    @Override
    public List<Category> retrieveAll() {
        List<Category> categoryList = new ArrayList<>();
        List<CategoryEntity> categoryEntityList = repository.findAll();
        categoryEntityList.forEach(categoryEntity -> {
            categoryList.add(new ModelMapper().map(categoryEntity, Category.class));
        });
        return categoryList;
    }

    @Override
    public Category retrieveById(Long id) {
        Optional<CategoryEntity> categoryEntity = repository.findById(id);
        if (categoryEntity.isEmpty()){
            throw new CategoryNotFoundException(String.format("%d No category found with this ID",id));
        }
        return new ModelMapper().map(categoryEntity, Category.class);
    }

    @Override
    public void update(Category category) {
        if (repository.findById(category.getId()).isEmpty()){
            throw new CategoryNotFoundException(String.format("%s this category not found",category));
        }
        repository.save(new ModelMapper().map(category, CategoryEntity.class));
    }

    @Override
    public void deleteById(Long id) {
        if (repository.findById(id).isEmpty()){
            throw new CategoryNotFoundException(String.format("%d No category found with this ID",id));
        }
        repository.deleteById(id);
    }
}
