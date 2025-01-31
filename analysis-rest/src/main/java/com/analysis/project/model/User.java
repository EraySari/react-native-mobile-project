package com.analysis.project.model;

import com.analysis.project.enums.GenderType;
import com.analysis.project.enums.RoleType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.Period;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "tc"),
        @UniqueConstraint(columnNames = "email")
})
@AllArgsConstructor
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;

    @Column(unique = true, length = 5)
    private String tc;

    private Integer month;
    private String password;

    private String email;

    @Enumerated(EnumType.STRING)
    private RoleType role;

    @Enumerated(EnumType.STRING)
    private GenderType gender;

    private LocalDate birthDate;



    public User(String tc, String password, String name, String email, RoleType role) {
        this.tc = tc;
        this.password = password;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    @PrePersist
    @PreUpdate
    private void prePersist() {
        if (birthDate != null) {
            Period period = Period.between(birthDate, LocalDate.now());
            this.month = period.getYears() * 12 + period.getMonths();
        } else {
            this.month = null;
        }
    }


}