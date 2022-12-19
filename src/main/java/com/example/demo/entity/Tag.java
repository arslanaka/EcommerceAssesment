package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Tag")
public class Tag {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tagId")
    private Integer tagID;

    @Column(name = "tag")
    private String tags;

    public Integer getTagID() {
        return tagID;
    }

    public void setTagID(Integer tagID) {
        this.tagID = tagID;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
