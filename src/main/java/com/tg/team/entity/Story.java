package com.tg.team.entity;

import javax.persistence.*;

@Entity
@Table(name = "storys")
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="story_type")
    private String storyType;

    public Story(long id, String storyType) {
        this.id = id;
        this.storyType = storyType;
    }

    public Story() {
    }

    public long getId() {
        return id;
    }

    public String getStoryType() {
        return storyType;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setStoryType(String storyType) {
        this.storyType = storyType;
    }
}
