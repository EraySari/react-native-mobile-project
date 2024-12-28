package com.analysis.project.repository;

import com.analysis.project.model.BloodAnalysis;
import com.analysis.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BloodAnalysisRepository extends JpaRepository<BloodAnalysis, Long> {


    @Query("SELECT b FROM BloodAnalysis b WHERE b.user = :user ORDER BY b.date DESC")
    List<BloodAnalysis> findByUserOrderByDateDesc(@Param("user") User user);


    List<BloodAnalysis> findByUser(User user);
}

