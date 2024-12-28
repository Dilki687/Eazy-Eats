package com.food.response;

import lombok.Data;

@Data
public class MessageResponse {
    public void setMessage(String message) {
        this.message = message;
    }

    private String message;

    public String getMessage() {
        return message;
    }
}
