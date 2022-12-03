package com.tg.team.dto;

public class AddMemberRequest {
    private String name;
    private String memberType;
    private Long storyId;

    public AddMemberRequest(String name, String memberType, Long storyId) {
        this.name = name;
        this.memberType = memberType;
        this.storyId = storyId;
    }

    public AddMemberRequest() {
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

    public Long getStoryId() {
        return storyId;
    }

    public void setStoryId(Long storyId) {
        this.storyId = storyId;
    }
}
