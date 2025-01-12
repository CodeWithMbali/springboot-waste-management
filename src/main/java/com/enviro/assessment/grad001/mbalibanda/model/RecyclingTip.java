package com.enviro.assessment.grad001.mbalibanda.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Represents a recycling tip entity stored in the database.
 */
@Entity
public class RecyclingTip {

    // Auto-generated primary key for each record
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Recycling tip content (mandatory and limited to 500 characters)
    @NotBlank(message = "Tip is mandatory")
    @Size(max = 500, message = "Tip must not exceed 500 characters")
    private String tip;

    // Many-to-one relationship with WasteCategory
    @ManyToOne(optional = false)
    private WasteCategory wasteCategory;

    // Default constructor
    public RecyclingTip() {}

    // Constructor for convenience
    public RecyclingTip(String tip, WasteCategory wasteCategory) {
        this.tip = tip;
        this.wasteCategory = wasteCategory;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public WasteCategory getWasteCategory() {
        return wasteCategory;
    }

    public void setWasteCategory(WasteCategory wasteCategory) {
        this.wasteCategory = wasteCategory;
    }
}

