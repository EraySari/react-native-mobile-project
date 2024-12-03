package com.analysis.project.service;

import com.analysis.project.handler.BloodAnalysisNotFoundException;
import com.analysis.project.model.BloodAnalysis;
import com.analysis.project.model.User;
import com.analysis.project.repository.BloodAnalysisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BloodAnalysisServiceImpl implements BloodAnalysisService {

    private final BloodAnalysisRepository bloodAnalysisRepository;

    @Override
    public List<BloodAnalysis> findAllBloodAnalysis() {
        return bloodAnalysisRepository.findAll();
    }

    @Override
    public List<BloodAnalysis> findBloodAnalysisByUser(User user) {
        return bloodAnalysisRepository.findBloodAnalysisByUser(user);
    }

    @Override
    public Optional<BloodAnalysis> findByBloodAnalysisId(Long id) {
        return Optional.ofNullable(bloodAnalysisRepository.findById(id).orElseThrow(() -> new BloodAnalysisNotFoundException("Not Found Analysis With " + id)));
    }

    @Override
    public BloodAnalysis save(BloodAnalysis analysis) {
        return bloodAnalysisRepository.save(analysis);
    }

    @Override
    public BloodAnalysis update(Long id, BloodAnalysis analysis) {
        return bloodAnalysisRepository.findById(id)
                .map(existingAnalysis->{
                    existingAnalysis.setIgA(analysis.getIgA());
                    existingAnalysis.setIgM(analysis.getIgM());
                    existingAnalysis.setIgG(analysis.getIgG());
                    existingAnalysis.setIgG1(analysis.getIgG1());
                    existingAnalysis.setIgG2(analysis.getIgG2());
                    existingAnalysis.setIgG3(analysis.getIgG3());
                    existingAnalysis.setIgG4(analysis.getIgG4());
                    existingAnalysis.setUser(analysis.getUser());
                    existingAnalysis.setDate(analysis.getDate());

                    return bloodAnalysisRepository.save(existingAnalysis);
                })
                .orElseThrow(() -> new BloodAnalysisNotFoundException("Not Found Analysis"));
    }

    @Override
    public void delete(Long id) {
        if (!bloodAnalysisRepository.existsById(id)) {
            throw new BloodAnalysisNotFoundException("Not Found Analysis");
        }
        bloodAnalysisRepository.deleteById(id);
    }
}
