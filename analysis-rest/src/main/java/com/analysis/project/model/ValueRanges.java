package com.analysis.project.model;

import com.analysis.project.enums.ValueNameType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ValueRanges {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer minMonth;
    private Integer maxMonth;

    @Enumerated(EnumType.STRING)
    private ValueNameType valueName;

    private Double minValue;
    private Double maxValue;

    public ValueRanges(Integer minMonth, Integer maxMonth, ValueNameType valueName, Double minValue, Double maxValue) {
        this.minMonth = minMonth;
        this.maxMonth = maxMonth;
        this.valueName = valueName;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }
}
