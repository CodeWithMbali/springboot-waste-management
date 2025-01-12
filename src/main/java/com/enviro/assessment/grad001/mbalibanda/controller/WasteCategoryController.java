package com.enviro.assessment.grad001.mbalibanda.controller;

import com.enviro.assessment.grad001.mbalibanda.model.WasteCategory;
import com.enviro.assessment.grad001.mbalibanda.service.WasteCategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/waste-categories")
public class WasteCategoryController {

    private final WasteCategoryService service;

    public WasteCategoryController(WasteCategoryService service) {
        this.service = service;
    }

    @GetMapping
    public List<WasteCategory> getAllCategories() {
        return service.getAllCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<WasteCategory> getCategoryById(@PathVariable Long id) {
        Optional<WasteCategory> category = service.getCategoryById(id);
        return category.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createCategory(@Valid @RequestBody WasteCategory category, BindingResult result) {
        if (result.hasErrors()) {
            return handleValidationErrors(result);
        }
        WasteCategory savedCategory = service.saveCategory(category);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Long id, @Valid @RequestBody WasteCategory category, BindingResult result) {
        if (result.hasErrors()) {
            return handleValidationErrors(result);
        }

        Optional<WasteCategory> existingCategory = service.getCategoryById(id);
        if (existingCategory.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        // Update the category fields and save
        WasteCategory updatedCategory = existingCategory.get();
        updatedCategory.setName(category.getName());
        updatedCategory.setDescription(category.getDescription());
        service.saveCategory(updatedCategory);

        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        service.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Handles validation errors by constructing a map of field errors.
     *
     * @param result the binding result containing validation errors
     * @return a ResponseEntity with error details
     */
    private ResponseEntity<Map<String, String>> handleValidationErrors(BindingResult result) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : result.getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
