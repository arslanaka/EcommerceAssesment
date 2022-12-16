package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.text.DecimalFormat;
import java.time.LocalDateTime;

@Entity(name = "offer")
@Data
public class Offer {

    @Id
    @Column(name = "offerId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer offerId;

    @Column(name = "offerName")
    private String offerName;

    @Column(name = "category")
    private Integer category;

    @Column(name = "subcategory")
    private Integer subCategory;

    @Column(name = "image")
    private Integer image;

    @Column(name = "featured")
    private Boolean featured;

    @Column(name = "prorityRanking")
    private Integer priorityRanking;

    @Column(name = "locationsOffered")
    private String locationsOffered;

    @Column(name = "tags")
    private String tags;

    @Column(name = "tagline")
    private String tagline;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private DecimalFormat price;

    @Column(name = "currency")
    private String currency;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


}
