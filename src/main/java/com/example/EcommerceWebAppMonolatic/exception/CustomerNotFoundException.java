package com.example.EcommerceWebAppMonolatic.exception;

import lombok.Data;

@Data
public class CustomerNotFoundException extends RuntimeException{
    private final String errorCode;

    public CustomerNotFoundException(String message,String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
