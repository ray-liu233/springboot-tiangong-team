package com.tg.team.dto;

public class AddMemberRequest {
    private long id;
    private String name;
    private String memberType;

    public AddMemberRequest(long id, String name, String memberType) {
        this.id = id;
        this.name = name;
        this.memberType = memberType;
    }

    public AddMemberRequest() {
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
