package com.analysis.project.repository;

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
}
