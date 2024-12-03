package com.analysis.project.service;

import com.analysis.project.handler.ValueRangeNotFoundException;
import com.analysis.project.model.ValueRanges;
import com.analysis.project.repository.ValueRangesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ValueRangeServiceImpl implements ValueRangesService{

    private final ValueRangesRepository valueRangesRepository;

    @Override
    public List<ValueRanges> findAllValueRanges() {
        return valueRangesRepository.findAll();
    }

    @Override
    public List<ValueRanges> findValueRangesByMonth(int month) {
        return valueRangesRepository.findByMonthRange(month);
    }

    @Override
    public Optional<ValueRanges> findByValueRangeId(Long id) {
        return Optional.ofNullable(valueRangesRepository.findById(id).orElseThrow(() -> new ValueRangeNotFoundException("Value Not Found With "+id)));
    }

    @Override
    public ValueRanges save(ValueRanges value) {
        return valueRangesRepository.save(value);
    }

    @Override
    public ValueRanges update(Long id, ValueRanges value) {
        return valueRangesRepository.findById(id)
                .map(existingValue->{
                    existingValue.setMaxValue(value.getMaxValue());
                    existingValue.setMinValue(value.getMinValue());
                    existingValue.setValueName(value.getValueName());
                    existingValue.setMaxMonth(value.getMaxMonth());
                    existingValue.setMinMonth(value.getMinMonth());

                    return valueRangesRepository.save(existingValue);
                })
                .orElseThrow(() -> new ValueRangeNotFoundException("Not Found Value Range"));
    }

    @Override
    public void delete(Long id) {

        if (!valueRangesRepository.existsById(id)) {
            throw new ValueRangeNotFoundException("Not Found Value Range");
        }
        valueRangesRepository.deleteById(id);
    }
}
