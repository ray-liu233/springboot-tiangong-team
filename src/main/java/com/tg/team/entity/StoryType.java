package com.tg.team.entity;

public enum StoryType {
    NEW("NEW"),
    ASSIGNED("ASSIGNED"),
    DONE("DONE"),
    DELETED("DELETED");

    private final String typeName;

    StoryType(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }
}
