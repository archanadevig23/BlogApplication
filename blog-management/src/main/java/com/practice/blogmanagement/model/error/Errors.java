package com.practice.blogmanagement.model.error;

public enum Errors {

    USER_EXISTS(1001, "User already exists"),
    USER_DOESNT_EXISTS(1002, "User doesn't exists");

    public final int code;

    public final String message;

    Errors(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
