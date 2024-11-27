package com.analysis.project.bootstrap;

import com.analysis.project.enums.ValueNameType;
import com.analysis.project.model.ValueRanges;
import com.analysis.project.repository.ValueRangesRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Profile("bootstrap")
@RequiredArgsConstructor
@Transactional
@Slf4j
public class Bootstrap implements CommandLineRunner {

    private final ValueRangesRepository valueRangesRepository;

    @Override
    public void run(String... args) throws Exception {

        if (valueRangesRepository.count() < 1) {

            List<ValueRanges> valueRangesList = List.of(
                    new ValueRanges(0,4, ValueNameType.IgG,1.0,1.34),
                    new ValueRanges(5,8, ValueNameType.IgG,1.64,5.58),
                    new ValueRanges(9,14, ValueNameType.IgG,2.46,9.04),
                    new ValueRanges(15,23, ValueNameType.IgG,3.13,11.70),
                    new ValueRanges(24,36, ValueNameType.IgG,2.95,11.56),
                    new ValueRanges(48,72, ValueNameType.IgG,3.86,14.70),
                    new ValueRanges(84,108, ValueNameType.IgG,4.62,16.82),
                    new ValueRanges(120,144, ValueNameType.IgG,5.03,15.80),
                    new ValueRanges(156,180, ValueNameType.IgG,5.09,15.80),
                    new ValueRanges(192,204, ValueNameType.IgG,4.87,13.27),
                    new ValueRanges(216,1200, ValueNameType.IgG,7.67,15.90),

                    new ValueRanges(0,4, ValueNameType.IgG1,0.56,2.15),
                    new ValueRanges(5,8, ValueNameType.IgG1,1.02,3.69),
                    new ValueRanges(9,14, ValueNameType.IgG1,1.60,5.62),
                    new ValueRanges(15,23, ValueNameType.IgG1,2.09,7.24),
                    new ValueRanges(24,36, ValueNameType.IgG1,1.58,7.21),
                    new ValueRanges(48,72, ValueNameType.IgG1,2.09,9.02),
                    new ValueRanges(84,108, ValueNameType.IgG1,2.53,10.19),
                    new ValueRanges(120,144, ValueNameType.IgG1,2.80,10.30),
                    new ValueRanges(156,180, ValueNameType.IgG1,2.89,9.34),
                    new ValueRanges(192,204, ValueNameType.IgG1,2.83,7.72),
                    new ValueRanges(216,1200, ValueNameType.IgG1,3.41,8.94),

                    new ValueRanges(0,4, ValueNameType.IgG2,0.0,0.82),
                    new ValueRanges(5,8, ValueNameType.IgG2,0.0,0.89),
                    new ValueRanges(9,14, ValueNameType.IgG2,0.24,0.98),
                    new ValueRanges(15,23, ValueNameType.IgG2,0.35,1.05),
                    new ValueRanges(24,36, ValueNameType.IgG2,0.39,1.76),
                    new ValueRanges(48,72, ValueNameType.IgG2,0.44,3.16),
                    new ValueRanges(84,108, ValueNameType.IgG2,0.54,4.35),
                    new ValueRanges(120,144, ValueNameType.IgG2,0.66,5.02),
                    new ValueRanges(156,180, ValueNameType.IgG2,0.82,5.16),
                    new ValueRanges(192,204, ValueNameType.IgG2,0.98,4.86),
                    new ValueRanges(216,1200, ValueNameType.IgG2,1.71,6.32),

                    new ValueRanges(0,4, ValueNameType.IgG3,0.076,8.23),
                    new ValueRanges(5,8, ValueNameType.IgG3,0.119,0.740),
                    new ValueRanges(9,14, ValueNameType.IgG3,0.173,0.637),
                    new ValueRanges(15,23, ValueNameType.IgG3,0.219,0.550),
                    new ValueRanges(24,36, ValueNameType.IgG3,0.170,0.847),
                    new ValueRanges(48,72, ValueNameType.IgG3,0.108,0.949),
                    new ValueRanges(84,108, ValueNameType.IgG3,0.085,10.26),
                    new ValueRanges(120,144, ValueNameType.IgG3,0.115,10.53),
                    new ValueRanges(156,180, ValueNameType.IgG3,0.200,10.32),
                    new ValueRanges(192,204, ValueNameType.IgG3,0.313,0.976),
                    new ValueRanges(216,1200, ValueNameType.IgG3,0.184,10.60),

                    new ValueRanges(0,4, ValueNameType.IgG4,0.0,0.198),
                    new ValueRanges(5,8, ValueNameType.IgG4,0.0,0.208),
                    new ValueRanges(9,14, ValueNameType.IgG4,0.0,0.220),
                    new ValueRanges(15,23, ValueNameType.IgG4,0.0,0.230),
                    new ValueRanges(24,36, ValueNameType.IgG4,0.004,0.491),
                    new ValueRanges(48,72, ValueNameType.IgG4,0.008,0.819),
                    new ValueRanges(84,108, ValueNameType.IgG4,0.010,1.087),
                    new ValueRanges(120,144, ValueNameType.IgG4,0.010,1.219),
                    new ValueRanges(156,180, ValueNameType.IgG4,0.007,1.217),
                    new ValueRanges(192,204, ValueNameType.IgG4,0.003,1.110),
                    new ValueRanges(216,1200, ValueNameType.IgG4,0.024,1.210),

                    new ValueRanges(0,4, ValueNameType.IgA,0.07,0.37),
                    new ValueRanges(5,8, ValueNameType.IgA,0.16,0.50),
                    new ValueRanges(9,14, ValueNameType.IgA,0.27,0.66),
                    new ValueRanges(15,23, ValueNameType.IgA,0.36,0.79),
                    new ValueRanges(24,36, ValueNameType.IgA,0.27,2.46),
                    new ValueRanges(48,72, ValueNameType.IgA,0.29,2.56),
                    new ValueRanges(84,108, ValueNameType.IgA,0.34,2.74),
                    new ValueRanges(120,144, ValueNameType.IgA,0.42,2.95),
                    new ValueRanges(156,180, ValueNameType.IgA,0.52,3.19),
                    new ValueRanges(192,204, ValueNameType.IgA,0.60,3.37),
                    new ValueRanges(216,1200, ValueNameType.IgA,0.61,3.56),

                    new ValueRanges(0,4, ValueNameType.IgM,0.26,1.22),
                    new ValueRanges(5,8, ValueNameType.IgM,0.32,1.32),
                    new ValueRanges(9,14, ValueNameType.IgM,0.40,1.43),
                    new ValueRanges(15,23, ValueNameType.IgM,0.46,1.52),
                    new ValueRanges(24,36, ValueNameType.IgM,0.37,1.84),
                    new ValueRanges(48,72, ValueNameType.IgM,0.37,2.24),
                    new ValueRanges(84,108, ValueNameType.IgM,0.38,2.51),
                    new ValueRanges(120,144, ValueNameType.IgM,0.41,2.55),
                    new ValueRanges(156,180, ValueNameType.IgM,0.45,2.44),
                    new ValueRanges(192,204, ValueNameType.IgM,0.49,2.01),
                    new ValueRanges(216,1200, ValueNameType.IgM,0.37,2.86)
                    );

            valueRangesRepository.saveAll(valueRangesList);



        }

    }
}
