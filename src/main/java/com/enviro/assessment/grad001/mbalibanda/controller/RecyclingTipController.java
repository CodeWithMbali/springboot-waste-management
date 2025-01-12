package com.enviro.assessment.grad001.mbalibanda.controller;

import com.enviro.assessment.grad001.mbalibanda.model.RecyclingTip;
import com.enviro.assessment.grad001.mbalibanda.service.RecyclingTipService;
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
@RequestMapping("/api/recycling-tips")
public class RecyclingTipController {

    private final RecyclingTipService service;

    public RecyclingTipController(RecyclingTipService service) {
        this.service = service;
    }

    @GetMapping
    public List<RecyclingTip> getAllTips() {
        return service.getAllTips();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecyclingTip> getTipById(@PathVariable Long id) {
        Optional<RecyclingTip> tip = service.getTipById(id);
        return tip.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createTip(@Valid @RequestBody RecyclingTip tip, BindingResult result) {
        if (result.hasErrors()) {
            return handleValidationErrors(result);
        }
        RecyclingTip savedTip = service.saveTip(tip);
        return new ResponseEntity<>(savedTip, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTip(@PathVariable Long id, @Valid @RequestBody RecyclingTip tip, BindingResult result) {
        if (result.hasErrors()) {
            return handleValidationErrors(result);
        }

        Optional<RecyclingTip> existingTip = service.getTipById(id);
        if (existingTip.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        RecyclingTip updatedTip = existingTip.get();
        updatedTip.setTip(tip.getTip());
        updatedTip.setWasteCategory(tip.getWasteCategory());
        service.saveTip(updatedTip);

        return ResponseEntity.ok(updatedTip);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTip(@PathVariable Long id) {
        service.deleteTip(id);
        return ResponseEntity.noContent().build();
    }
       /*
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

