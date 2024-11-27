package com.analysis.project.service;

import com.analysis.project.model.BloodAnalysis;
import com.analysis.project.model.User;
import com.analysis.project.model.ValueRanges;

import java.util.List;
import java.util.Optional;

public interface ValueRangesService {

    List<ValueRanges> findAllValueRanges();

    List<ValueRanges> findValueRangesByMonth(int month);

    Optional<ValueRanges> findByValueRangeId(Long id);

    ValueRanges save(ValueRanges value);

    ValueRanges update(Long id,ValueRanges value);

    void delete(Long id);
}
