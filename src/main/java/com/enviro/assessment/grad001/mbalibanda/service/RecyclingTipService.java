package com.enviro.assessment.grad001.mbalibanda.service;

import com.enviro.assessment.grad001.mbalibanda.model.RecyclingTip;
import com.enviro.assessment.grad001.mbalibanda.repository.RecyclingTipRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecyclingTipService {

    private final RecyclingTipRepository repository;

    public RecyclingTipService(RecyclingTipRepository repository) {
        this.repository = repository;
    }

    // Retrieve all recycling tips
    public List<RecyclingTip> getAllTips() {
        return repository.findAll();
    }

    // Retrieve a recycling tip by ID
    public Optional<RecyclingTip> getTipById(Long id) {
        return repository.findById(id);
    }

    // Save a new or updated recycling tip
    public RecyclingTip saveTip(RecyclingTip tip) {
        return repository.save(tip);
    }

    // Delete a recycling tip by ID
    public void deleteTip(Long id) {
        repository.deleteById(id);
    }
}

