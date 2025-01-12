package com.enviro.assessment.grad001.mbalibanda.controller;

import com.enviro.assessment.grad001.mbalibanda.model.DisposalGuideline;
import com.enviro.assessment.grad001.mbalibanda.service.DisposalGuidelineService;
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
@RequestMapping("/api/disposal-guidelines")
public class DisposalGuidelineController {

    private final DisposalGuidelineService service;

    public DisposalGuidelineController(DisposalGuidelineService service) {
        this.service = service;
    }

    @GetMapping
    public List<DisposalGuideline> getAllGuidelines() {
        return service.getAllGuidelines();
    }

    @GetMapping("/category/{categoryId}")
    public List<DisposalGuideline> getGuidelinesByCategoryId(@PathVariable Long categoryId) {
        return service.getGuidelinesByCategoryId(categoryId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisposalGuideline> getGuidelineById(@PathVariable Long id) {
        Optional<DisposalGuideline> guideline = service.getGuidelineById(id);
        return guideline.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createGuideline(@Valid @RequestBody DisposalGuideline guideline, BindingResult result) {
        if (result.hasErrors()) {
            return handleValidationErrors(result);
        }
        DisposalGuideline savedGuideline = service.saveGuideline(guideline);
        return new ResponseEntity<>(savedGuideline, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuideline(@PathVariable Long id) {
        service.deleteGuideline(id);
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

