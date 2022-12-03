package com.tg.team.entity;

import javax.persistence.*;

@Entity
@Table(name = "stories")
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name="story_type")
    private String storyType;

    public Story( String storyType) {
        this.storyType = storyType;
    }

    public Story() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setStoryType(String storyType) {
        this.storyType = storyType;
    }

    public String getStoryType() {
        return storyType;
    }
}
