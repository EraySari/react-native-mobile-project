package com.analysis.project.repository;

import com.analysis.project.model.BloodAnalysis;
import com.analysis.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BloodAnalysisRepository extends JpaRepository<BloodAnalysis, Long> {

    List<BloodAnalysis> findBloodAnalysisByUser(User user);


    List<BloodAnalysis> findByUser(User user);
}

