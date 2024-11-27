package com.analysis.project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BloodAnalysis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double IgA;
    private Double IgM;
    private Double IgG;
    private Double IgG1;
    private Double IgG2;
    private Double IgG3;
    private Double IgG4;

    private OffsetDateTime date;

    @ManyToOne
    @JoinColumn(name = "user_id" ,nullable = false)
    private User user;

    @PrePersist
    public void prePersist() {
        if (this.date == null) {
            this.date = OffsetDateTime.now();
        }
    }



}
