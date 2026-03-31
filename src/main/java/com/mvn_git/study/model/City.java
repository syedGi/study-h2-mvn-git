package com.mvn_git.study.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "city")
public class City extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Name", nullable = false, length = 35)
    private String name;

    @Column(name = "CountryCode", nullable = false, length = 10)
    private String countryCode;

    @Column(name = "District", nullable = false, length = 20)
    private String district;

    @Column(name = "Population", nullable = false)
    private Integer population;

    
}
// ALTER TABLE city ADD COLUMN CREATED_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP;