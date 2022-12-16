package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "Cities")
public class City {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "cityId")
    private String cityId;

    @Column(name = "city")
    private String city;

    @Column(name = "countryCode")
    private Integer countryCode;

    @Column(name = "country")
    private String country;

    @Column(name = "active")
    private Boolean active;



}
