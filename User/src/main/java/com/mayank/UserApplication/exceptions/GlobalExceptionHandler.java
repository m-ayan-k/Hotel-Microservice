package com.mayank.UserApplication.exceptions;

import com.mayank.UserApplication.payload.ApiResponse;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice

public class GlobalExceptionHandler {

        @ExceptionHandler(ConfigDataResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ConfigDataResourceNotFoundException ex){
            String message = ex.getMessage();
            ApiResponse response = ApiResponse.builder()
                    .message(message)
                    .success(true)
                    .status(HttpStatus.NOT_FOUND)
                    .build();

            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }
}
