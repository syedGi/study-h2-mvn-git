package com.mvn_git.study.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "country")
public class Country extends BaseEntity {

    @Id
    @Column(name = "Code", length = 3, nullable = false)
    private String code;

    @Column(name = "Name", length = 52, nullable = false)
    private String name;

//    @Enumerated(EnumType.STRING)
    @Column(name = "Continent", nullable = false)
    private String continent;

    @Column(name = "Region", length = 26, nullable = false)
    private String region;

    @Column(name = "Surface_Area", nullable = false)
    private Float surfaceArea;

    @Column(name = "Indep_Year")
    private Short indepYear;

    @Column(name = "Population", nullable = false)
    private Integer population;
    
    @Column(name = "JOINED_DATE")
    private LocalDate joinedDate;

    @Column(name = "WORKING_FROM_DATE")
    private LocalDate workingFromDate;

}

//ALTER TABLE country
//ADD COLUMN JOINED_DATE DATE,
//ADD COLUMN WORKING_FROM_DATE DATE;