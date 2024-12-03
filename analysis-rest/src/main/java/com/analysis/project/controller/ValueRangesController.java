package com.analysis.project.controller;

import com.analysis.project.model.ValueRanges;
import com.analysis.project.service.ValueRangesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/values")
public class ValueRangesController {

    private final ValueRangesService valueRangesService;

    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<ValueRanges> findAllValueRanges() {
        return valueRangesService.findAllValueRanges();
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/month/{month}")
    public List<ValueRanges> findValueRangesByMonth(@PathVariable int month) {
        return valueRangesService.findValueRangesByMonth(month);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Optional<ValueRanges> findValueRangeById(@PathVariable Long id) {
        return valueRangesService.findByValueRangeId(id);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ValueRanges createValueRange(@RequestBody ValueRanges value) {
        return valueRangesService.save(value);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/{id}")
    public ValueRanges updateValueRange(@PathVariable Long id,@RequestBody ValueRanges value) {
        return valueRangesService.update(id,value);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteValueRange(@PathVariable Long id) {
        valueRangesService.delete(id);
    }

}
