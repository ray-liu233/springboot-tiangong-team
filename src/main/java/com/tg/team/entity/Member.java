package com.tg.team.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="member_name")
    private String name;
    @Column(name="member_type")
    private String memberType;

    @Column(name="story_id")
    private Long storyId;


    public Member(String name, String memberType, Long storyId) {
        this.name = name;
        this.memberType = memberType;
        this.storyId = storyId;
    }

    public Member() {
    }

    public Long getStoryId() {
        return storyId;
    }

    public void setStoryId(Long storyId) {
        this.storyId = storyId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }
}
