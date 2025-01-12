package com.enviro.assessment.grad001.mbalibanda.service;

import com.enviro.assessment.grad001.mbalibanda.model.WasteCategory;
import com.enviro.assessment.grad001.mbalibanda.repository.WasteCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WasteCategoryService {

    private final WasteCategoryRepository repository;

    public WasteCategoryService(WasteCategoryRepository repository) {
        this.repository = repository;
    }

    public List<WasteCategory> getAllCategories() {
        return repository.findAll();
    }

    public Optional<WasteCategory> getCategoryById(Long id) {
        return repository.findById(id);
    }

    public WasteCategory saveCategory(WasteCategory category) {
        return repository.save(category);
    }

    public void deleteCategory(Long id) {
        repository.deleteById(id);
    }
}
