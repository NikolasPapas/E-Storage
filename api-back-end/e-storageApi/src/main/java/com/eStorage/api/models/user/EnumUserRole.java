package com.eStorage.api.models.user;

public enum EnumUserRole {
    USER("User"),
    ADMIN("Admin"),
    GUEST("Guest"),
    MANAGER("manager");
    private String person;

    EnumUserRole(String person) {
        this.person = person;
    }
}
