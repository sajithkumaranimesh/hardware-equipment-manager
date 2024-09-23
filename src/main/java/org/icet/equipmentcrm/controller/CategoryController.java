package org.icet.equipmentcrm.controller;

import lombok.RequiredArgsConstructor;
import org.icet.equipmentcrm.dto.Category;
import org.icet.equipmentcrm.service.CategoryService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;

    @PostMapping()
    public void persist(@RequestBody Category category){
        service.persist(category);
    }
}
