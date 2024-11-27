package com.analysis.project.service;

import com.analysis.project.model.BloodAnalysis;
import com.analysis.project.model.User;

import java.util.List;
import java.util.Optional;

public interface BloodAnalysisService {

    List<BloodAnalysis> findAllBloodAnalysis();

    List<BloodAnalysis> findBloodAnalysisByUser(User user);

    Optional<BloodAnalysis> findByBloodAnalysisId(Long id);

    BloodAnalysis save(BloodAnalysis analysis);

    BloodAnalysis update(Long id,BloodAnalysis analysis);

    void delete(Long id);
}
