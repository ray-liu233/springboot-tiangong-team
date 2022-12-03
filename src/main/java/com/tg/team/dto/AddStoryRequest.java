package com.tg.team.dto;

public class AddStoryRequest {
    private String storyType;

    public AddStoryRequest(String storyType) {
        this.storyType = storyType;
    }

    public AddStoryRequest() {
    }
    public String getStoryType() {
        return storyType;
    }

    public void setStoryType(String storyType) {
        this.storyType = storyType;
    }
}
