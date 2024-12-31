package com.analysis.project.repository;

import com.analysis.project.enums.CalculateType;
import com.analysis.project.model.ValueRanges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ValueRangesRepository extends JpaRepository<ValueRanges, Long> {

    @Query("SELECT v FROM ValueRanges v WHERE :month BETWEEN v.minMonth AND v.maxMonth")
    List<ValueRanges> findByMonthRange(@Param("month") int month);

    @Query("SELECT DISTINCT v.guideType FROM ValueRanges v")
    List<String> findDistinctGuideTypes();

    @Query("SELECT DISTINCT v.calculateType FROM ValueRanges v")
    List<String> findDistinctCalculateTypes();

    @Query("SELECT DISTINCT vr.calculateType FROM ValueRanges vr WHERE vr.guideType = :guideType")
    List<CalculateType> findDistinctCalculateTypesByGuideType(String guideType);

}
