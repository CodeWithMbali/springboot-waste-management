package com.enviro.assessment.grad001.mbalibanda.repository;

import com.enviro.assessment.grad001.mbalibanda.model.DisposalGuideline;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DisposalGuidelineRepository extends JpaRepository<DisposalGuideline, Long> {
    List<DisposalGuideline> findByWasteCategoryId(Long wasteCategoryId); // Find guidelines by WasteCategory
}

