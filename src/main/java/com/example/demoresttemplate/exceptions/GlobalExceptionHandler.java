package com.example.demoresttemplate.exceptions;

import com.example.demoresttemplate.models.bo.Response;
import com.example.demoresttemplate.models.bo.SystemResponse;
import com.example.demoresttemplate.utils.StringResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import java.net.ConnectException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public ResponseEntity<SystemResponse<Object>> handleNotFoundException() {
//        handle exception here
        return null;
    }

    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    public ResponseEntity<SystemResponse<Object>> handleBadRequestException() {
        return Response.badRequest(StringResponse.BAD_REQUEST);
    }

    @ExceptionHandler(ConnectException.class)
    public ResponseEntity<SystemResponse<Object>> handleConnectException(ConnectException e) {
        return Response.internalServerError(StringResponse.CONNECTION_REFUSED);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<SystemResponse<Object>> handleException(Exception e) {
        return Response.internalServerError(e.getMessage());
    }
}
