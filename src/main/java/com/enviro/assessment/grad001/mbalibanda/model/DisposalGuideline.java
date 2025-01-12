package com.enviro.assessment.grad001.mbalibanda.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Represents disposal guidelines linked to a waste category.
 */
@Entity
public class DisposalGuideline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "waste_category_id", nullable = false)
    private WasteCategory wasteCategory; // Link to WasteCategory

    @NotBlank(message = "Guideline is mandatory")
    @Size(max = 500, message = "Guideline must not exceed 500 characters")
    private String guideline;

    // Default constructor
    public DisposalGuideline() {}

    // Constructor with fields
    public DisposalGuideline(WasteCategory wasteCategory, String guideline) {
        this.wasteCategory = wasteCategory;
        this.guideline = guideline;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public WasteCategory getWasteCategory() {
        return wasteCategory;
    }

    public void setWasteCategory(WasteCategory wasteCategory) {
        this.wasteCategory = wasteCategory;
    }

    public String getGuideline() {
        return guideline;
    }

    public void setGuideline(String guideline) {
        this.guideline = guideline;
    }
}

