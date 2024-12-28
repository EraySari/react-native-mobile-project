package com.analysis.project.service;


import com.analysis.project.model.ValueRanges;

import java.util.List;
import java.util.Optional;

public interface ValueRangesService {

    List<ValueRanges> findAllValueRanges();

    List<ValueRanges> findValueRangesByMonth(int month);

    Optional<ValueRanges> findByValueRangeId(Long id);

    List<String> getUniqueGuideTypes();

    ValueRanges save(ValueRanges value);

    ValueRanges update(Long id,ValueRanges value);

    void delete(Long id);
}
