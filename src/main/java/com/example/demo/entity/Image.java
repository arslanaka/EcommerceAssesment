package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "Images")
public class Image {


    @Id
    @Column(name = "imageId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "image")
    private byte[] image;
    @Column(name = "img_primary")
    private Boolean imgPrimary;




}
