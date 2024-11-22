package com.example.EcommerceWebAppMonolatic.exception;

import lombok.Data;

@Data
public class NotificationNotFoundException extends RuntimeException{
    private final String errorCode;

    public NotificationNotFoundException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
