package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "Images")
@Entity
public class Image {


    @Id
    @Column(name = "image_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "image")
    private Byte[] image;
    @Column(name = "img_primary")
    private Boolean imgPrimary;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public Boolean getImgPrimary() {
        return imgPrimary;
    }

    public void setImgPrimary(Boolean imgPrimary) {
        this.imgPrimary = imgPrimary;
    }
}
