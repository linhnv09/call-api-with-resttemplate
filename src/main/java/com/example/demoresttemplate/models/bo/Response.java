package com.example.demoresttemplate.models.bo;

import com.example.demoresttemplate.utils.StringResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Response {
    public static <T> ResponseEntity<SystemResponse<T>> ok() {
        return ResponseEntity.ok().body(new SystemResponse<>(200, "SUCCESS !"));
    }

    public static <T> ResponseEntity<SystemResponse<T>> ok(String message, T data) {
        return ResponseEntity.ok().body(new SystemResponse<>(200, message, data));
    }

    public static <T> ResponseEntity<SystemResponse<T>> badRequest(String message) {
        return ResponseEntity
                .badRequest()
                .body(new SystemResponse<>(400, message));
    }

    public static <T> ResponseEntity<SystemResponse<T>> internalServerError(String message) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new SystemResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), message));
    }
}
