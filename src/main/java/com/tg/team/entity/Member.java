package com.tg.team.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="member_name")
    private String name;
    @Column(name="member_type")
    private String memberType;

    @OneToMany(targetEntity = Story.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Story> stories;

    public void addStory(Story story){stories.add(story);}

    public Member(long id, String name, String memberType) {
        this.id = id;
        this.name = name;
        this.memberType = memberType;
    }

    public Member() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }
}
