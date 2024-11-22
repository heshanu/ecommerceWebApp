package com.example.EcommerceWebAppMonolatic.exception.handle;

import com.example.EcommerceWebAppMonolatic.dto.ErrorResponseDTO;
import com.example.EcommerceWebAppMonolatic.exception.NotificationNotFoundException;
import com.example.EcommerceWebAppMonolatic.exception.OrderNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NotificationNotFoundExceptionHandler extends RuntimeException{
    @ExceptionHandler(NotificationNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleControllerNotFound(NotificationNotFoundException exception) {
        ErrorResponseDTO errorResponse = ErrorResponseDTO.builder()
                .errorMessage(exception.getMessage())
                .errorCode(exception.getErrorCode())
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
