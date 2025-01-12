package com.enviro.assessment.grad001.mbalibanda.service;

import com.enviro.assessment.grad001.mbalibanda.model.DisposalGuideline;
import com.enviro.assessment.grad001.mbalibanda.repository.DisposalGuidelineRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisposalGuidelineService {

    private final DisposalGuidelineRepository repository;

    public DisposalGuidelineService(DisposalGuidelineRepository repository) {
        this.repository = repository;
    }

    public List<DisposalGuideline> getAllGuidelines() {
        return repository.findAll();
    }

    public List<DisposalGuideline> getGuidelinesByCategoryId(Long categoryId) {
        return repository.findByWasteCategoryId(categoryId);
    }

    public Optional<DisposalGuideline> getGuidelineById(Long id) {
        return repository.findById(id);
    }

    public DisposalGuideline saveGuideline(DisposalGuideline guideline) {
        return repository.save(guideline);
    }

    public void deleteGuideline(Long id) {
        repository.deleteById(id);
    }
}

