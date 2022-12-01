package com.tg.team.entity;

public enum MemberType {
    BA("BA"),
    DEV("DEV"),
    QA("QA");

    private final String typeName;
    MemberType(String typeName) {
        this.typeName=typeName;
    }

    public String getTypeName() {
        return typeName;
    }
}
