package com.example.EcommerceWebAppMonolatic.exception;

import lombok.Data;

@Data
public class OrderNotFoundException extends RuntimeException{
    private final String errorCode;

    public OrderNotFoundException (String message,String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
