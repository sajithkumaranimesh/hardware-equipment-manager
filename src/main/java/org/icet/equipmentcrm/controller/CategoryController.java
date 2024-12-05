package org.icet.equipmentcrm.controller;

import lombok.RequiredArgsConstructor;
import org.icet.equipmentcrm.dto.Category;
import org.icet.equipmentcrm.dto.SuccessResponse;
import org.icet.equipmentcrm.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void persist(@RequestBody Category category){
        service.persist(category);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<SuccessResponse> retrieveAll(@RequestParam(defaultValue = "0") int pageNo, @RequestParam(defaultValue = "8") int pageSize){
        List<Category> categoryList = service.retrieveAll(pageNo, pageSize);
        SuccessResponse successResponse = SuccessResponse.builder()
                .status("SUCCESS")
                .data(categoryList)
                .build();
        return ResponseEntity.ok().body(successResponse);
    }

    @GetMapping("/count")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<SuccessResponse> retrieveCount(){
        int count = service.retrieveAllCount();
        SuccessResponse successResponse = SuccessResponse.builder()
                .status("SUCCESS")
                .data(count)
                .build();
        return  ResponseEntity.ok().body(successResponse);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<SuccessResponse> retrieveById(@PathVariable Long id){
        Category category = service.retrieveById(id);
        SuccessResponse successResponse = SuccessResponse.builder()
                .status("SUCCESS")
                .data(category)
                .build();
        return ResponseEntity.ok().body(successResponse);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody Category category){
        service.update(category);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }
}
