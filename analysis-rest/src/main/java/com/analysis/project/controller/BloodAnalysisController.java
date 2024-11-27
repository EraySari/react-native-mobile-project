package com.analysis.project.controller;


import com.analysis.project.model.BloodAnalysis;
import com.analysis.project.model.User;
import com.analysis.project.service.BloodAnalysisService;
import com.analysis.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;


import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/analysis")
public class BloodAnalysisController {

    private final BloodAnalysisService bloodAnalysisService;
    private final UserService userService;

    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<BloodAnalysis> findAllBloodAnalysis() {
        return bloodAnalysisService.findAllBloodAnalysis();
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    @GetMapping("/user/{tc}/bookings")
    public List<BloodAnalysis> findBloodAnalysisByUser(@PathVariable String tc) {
        User user = userService.validateAndGetUserByTc(tc);
        return bloodAnalysisService.findBloodAnalysisByUser(user);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Optional<BloodAnalysis> findBloodAnalysisById(@PathVariable Long id) {
        return bloodAnalysisService.findByBloodAnalysisId(id);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public BloodAnalysis createBloodAnalysis(@RequestBody BloodAnalysis analysis) {
        return bloodAnalysisService.save(analysis);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/{id}")
    public BloodAnalysis updateBloodAnalysis(@PathVariable Long id,@RequestBody BloodAnalysis analysis) {
        return bloodAnalysisService.update(id,analysis);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteBloodAnalysis(@PathVariable Long id) {
        bloodAnalysisService.delete(id);
    }

}