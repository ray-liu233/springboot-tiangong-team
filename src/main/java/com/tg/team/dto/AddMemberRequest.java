package com.tg.team.dto;

public class AddMemberRequest {
    private String name;
    private String memberType;

    public AddMemberRequest(String name, String memberType) {
        this.name = name;
        this.memberType = memberType;
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
}
