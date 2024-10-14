package com.example.demo.Exception;

import org.springframework.http.HttpStatus;

public class CustomException extends Exception {

    private String errorCode;

    private HttpStatus httpStatus;

    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, String errorCode, HttpStatus httpStatus) {
        super(message);
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
