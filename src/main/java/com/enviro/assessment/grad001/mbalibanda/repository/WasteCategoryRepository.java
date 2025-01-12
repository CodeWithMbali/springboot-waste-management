package com.enviro.assessment.grad001.mbalibanda.repository;

import com.enviro.assessment.grad001.mbalibanda.model.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for WasteCategory entity.
 * Extends JpaRepository to provide CRUD and query operations.
 */
public interface WasteCategoryRepository extends JpaRepository<WasteCategory, Long> {
}

