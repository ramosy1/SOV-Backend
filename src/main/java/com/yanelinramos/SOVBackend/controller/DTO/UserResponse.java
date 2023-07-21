package com.yanelinramos.SOVBackend.controller.DTO;

public class UserResponse {
    private String code;
    private String message;

    public UserResponse() {
    }

    public UserResponse(String code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
