package com.demo.Login.dto;

public class ResponceDTO {
    public String message;
    public Object object;

    public ResponceDTO(String message, Object object) {
        this.message = message;
        this.object = object;
    }
}
